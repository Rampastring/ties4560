package servlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;

public class ServletRunner {

	public static void main(String[] args) throws Exception {
		RunServlets();
	}

	private static void RunServlets() {
		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(FullNameGenerator.class, "/getFullName");
		handler.addServletWithMapping(FirstNameGenerator.class, "/getFirstName");
		handler.addServletWithMapping(LastNameGenerator.class, "/getLastName");
		handler.addServletWithMapping(NameHistory.class, "/getNameHistory");
		
		ResourceHandler resHandler = new ResourceHandler();
		resHandler.setWelcomeFiles(new String[] {"index.html"});
		resHandler.setResourceBase(".");
		
		// Create a new Server, add the handler to it and start
		Server server = new Server(1234);
		try {
			HandlerList handlers = new HandlerList();
			handlers.setHandlers(new Handler[] {handler, resHandler});
			server.setHandler(handlers);
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
