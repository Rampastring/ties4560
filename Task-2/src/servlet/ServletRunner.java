package servlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class ServletRunner {

	public static void main(String[] args) throws Exception {
		RunServlets();
	}

	private static void RunServlets() {
		ServletHandler handler = new ServletHandler();
		// add all servlet to use to the handler, the second argument is the path (e.g.
		// http://localhost:8080/searchPublication)
		// TODO: Add servlet mappings to classes
		handler.addServletWithMapping(MyServlet.class, "/myservlet");
//		handler.addServletWithMapping(UserProfile.class, "/getProfile");
//		handler.addServletWithMapping(CreateUserProfile.class, "/createProfile");
		// Create a new Server, add the handler to it and start
		Server server = new Server(8080);
		try {
			server.setHandler(handler);
			server.start();
			// this dumps a lot of debug output to the console.
			server.dumpStdErr();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
