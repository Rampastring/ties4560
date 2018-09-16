/**
 * 
 */
package TIES4560.DropBoxApp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Janita
 * @version 16.9.2018
 *
 */
public class DropBoxService {

	private String redirectUri = "http://localhost:8085/DropBoxApp/";
	private String code = "";
	private String token = "";

	public DropBoxService() {

	}

	public String retrieveAccessToken() {
		return retrieveToken(getCode());
	}

	private String getCode() {
		return this.code;
	}

	public String retrieveToken(String retrievedCode) {
		try {
			StringBuilder tokenUri = new StringBuilder("code=" + URLEncoder.encode(code, "UTF-8"));
			tokenUri.append("&grant_type=" + URLEncoder.encode("authorization_code", "UTF-8"));
			tokenUri.append("&client_id=" + URLEncoder.encode("s9qjjppmafv0sbo", "UTF-8"));
			tokenUri.append("&client_secret=" + URLEncoder.encode("pdt0ng2oyq8349n", "UTF-8"));
			tokenUri.append("&redirect_uri=" + URLEncoder.encode(redirectUri, "UTF-8"));
			URL url = new URL("https://api.dropbox.com/1/oauth2/token");
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.dropboxapi.com/oauth2/token")
					.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", "" + tokenUri.toString().length());
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream());
			outputStreamWriter.write(tokenUri.toString());
			outputStreamWriter.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			String queryResult = response.toString();
			// InputStream response = conn.getInputStream();
			// Scanner s = new Scanner(response).useDelimiter("\\A");
			// String result = s.hasNext() ? s.next() : "";
			// JSONObject object = new JSONObject(result);
			// setAccessToken(object.get("access_token"));
			// response.close();
			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAccessToken();
	}

	private String getAccessToken() {
		return this.token;
	}

	private void setAccessToken(Object object) {
		this.token = String.valueOf(object);
	}

	// public String retrieveAuthorizationUri() throws
	// UnsupportedEncodingException, URISyntaxException {
	// String redirectUri = "http://localhost:8085/DropBoxApp";
	// URI uri = new URI("https://www.dropbox.com/oauth2/authorize");
	// StringBuilder request = new StringBuilder(uri.toString());
	// request.append("?client_id=" + URLEncoder.encode("s9qjjppmafv0sbo",
	// "UTF-8")); // app
	// // key
	// request.append("&response_type=" + URLEncoder.encode("code", "UTF-8"));
	// // retrieves
	// // code
	// request.append("&redirect_uri=" + URLEncoder.encode(redirectUri,
	// "UTF-8")); // localhost,
	// // change
	// // according
	// // to
	// // local
	// // IP
	//
	// return request.toString();
	// }

	public String retrieveAccessTokenUri() throws UnsupportedEncodingException, URISyntaxException {
		String redirectUri = "http://localhost:8085/DropBoxApp";
		URI uri = new URI("https://www.dropbox.com/oauth2/authorize");
		StringBuilder request = new StringBuilder(uri.toString());
		request.append("?client_id=" + URLEncoder.encode("s9qjjppmafv0sbo", "UTF-8")); // app
																						// key
		request.append("&response_type=" + URLEncoder.encode("token", "UTF-8")); // retrieves
																					// code
		request.append("&redirect_uri=" + URLEncoder.encode(redirectUri, "UTF-8")); // localhost,
																					// change
																					// according
																					// to
																					// local
																					// IP

		return request.toString();
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String postFileToDropBox(File f) {
		try {
			String content = "{\"path\": \"" + "Apps\\TIES4560_DB_App" + "\"}";
			HttpURLConnection conn = (HttpURLConnection) new URL("https://content.dropboxapi.com/2/files/upload")
					.openConnection();
			conn.setRequestProperty("Content-Type", "application/octet-stream");
			conn.addRequestProperty("Authorization", "Bearer " + token);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Dropbox-API-Arg", content);
			conn.setRequestProperty("Content-Length",
					String.valueOf(Files.readAllBytes(Paths.get(f.getPath())).length));

			DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
			writer.write(Files.readAllBytes(Paths.get(f.getPath())));
			writer.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			StringBuilder output = new StringBuilder();
	        while (br.readLine() != null) {
	                output.append(br.readLine());
	        }

	        conn.disconnect();
	        return output.toString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String createNewFolder(String folderPath) {
		try {
			String parameters = "{\"path\": \"" + folderPath + "\"}";
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.dropboxapi.com/2/files/create_folder")
					.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");    
	        conn.addRequestProperty("Authorization", "Bearer " + token);
	        conn.setDoOutput(true);
	        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream());
			outputStreamWriter.write(parameters);
			outputStreamWriter.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

	        StringBuilder output = new StringBuilder();
	        while (br.readLine() != null) {
	                output.append(br.readLine());
	        }

	        conn.disconnect();
	        return output.toString();
		}  catch (Exception e ) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public String getAccountInformation() {
		try {
			String content = "{\"account_id\": \"" + "dbid:AAA7QstdqTkMywlVKYQ6vdSuGnVKgOrdPkQ" + "\"}";
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.dropboxapi.com/2/users/get_account")
					.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer "+ token);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Content-Length", String.valueOf(content.length()));
			
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream());
			outputStreamWriter.write(content);
			outputStreamWriter.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			StringBuilder output = new StringBuilder();
	        while (br.readLine() != null) {
	                output.append(br.readLine());
	        }
			
			return output.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
