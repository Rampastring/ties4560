
using System.IO;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Azure.WebJobs;
using Microsoft.Azure.WebJobs.Extensions.Http;
using Microsoft.AspNetCore.Http;
using Microsoft.Azure.WebJobs.Host;
using Newtonsoft.Json;
using System.Net.Http;
using System;
using System.Threading.Tasks;
using Newtonsoft.Json.Linq;
using System.Text;
using System.Security.Cryptography;

namespace GithubReceiverFunction
{
    public static class Function1
    {
        private const string Token = "REPLACE-WITH-GITHUB-TOKEN";

        private static HttpClient client;
        private static HMACSHA1 hashObject;

        [FunctionName("Function1")]
        public static async Task<IActionResult> Run([HttpTrigger(AuthorizationLevel.Function, "get", "post", Route = null)]HttpRequest req, TraceWriter log)
        {
            string signature = req.Headers["X-Hub-Signature"];
            if (hashObject == null)
                hashObject = new HMACSHA1(Encoding.ASCII.GetBytes(Token));

            string requestBody = new StreamReader(req.Body).ReadToEnd();

            // Verify message signature
            string expectedSignature = "sha1=" + BytesToString(hashObject.ComputeHash(Encoding.UTF8.GetBytes(requestBody)));
            if (signature != expectedSignature)
                return new BadRequestObjectResult($"Bad signature: {signature} vs {expectedSignature}");

            dynamic data = JsonConvert.DeserializeObject(requestBody);
            log.Info($"Data: {data}");

            // Get basic information
            string sender = data?.sender.login;
            JArray commitArray = (JArray)data?.commits;
            int commitCount = commitArray.Count;
            string compareUrl = data?.compare;
            string repositoryName = data?.repository.full_name;

            // Get commit messages
            StringBuilder commitMessages = new StringBuilder();
            foreach (JToken commitData in commitArray)
            {
                commitMessages.Append("- ");
                commitMessages.Append(commitData["message"].ToString());
                commitMessages.Append(Environment.NewLine);
            }

            if (sender == null || repositoryName == null || compareUrl == null || commitCount < 1 )
                return new BadRequestObjectResult("Failed to parse commit details.");

            if (client == null)
                client = new HttpClient();

            client.BaseAddress = new Uri("https://discordapp.com/api/webhooks/REPLACE-WITH-ID/REPLACE-WITH-TOKEN");
            var result = await client.PostAsJsonAsync("", new DiscordCommitMessage()
            { content = $"{sender} pushed {commitCount} commits to {repositoryName}." +
                        $" {Environment.NewLine}{commitMessages.ToString()} Compare changes: {compareUrl}" });

            log.Info($"Result: {result.Content.ReadAsStringAsync()}");
            return new OkResult();
        }

        private static string BytesToString(byte[] bytes)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.Length; i++)
            {
                sb.Append(bytes[i].ToString("x2"));
            }
            return sb.ToString();
        }
    }
}
