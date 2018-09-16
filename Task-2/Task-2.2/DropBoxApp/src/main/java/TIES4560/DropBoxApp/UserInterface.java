package TIES4560.DropBoxApp;

import java.io.File;
import java.net.URI;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("theme")
public class UserInterface extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	DropBoxService service = new DropBoxService();
    	final VerticalLayout layout = new VerticalLayout();
        Button button = new Button("Click to create access token");
        button.addClickListener(e -> {
        	try {
				getUI().getPage().setLocation(service.retrieveAccessTokenUri());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        Label label = new Label();
        
        Label label2 = new Label();
       
        
        Button tokenButton = new Button("Get access token");
        tokenButton.addClickListener(e -> {
        	URI current = getUI().getPage().getLocation();
        	String token = current.toString().substring(current.toString().indexOf("access_token=") + 13, current.toString().indexOf("&token_type"));
        	service.setToken(token);
//        	service.setCode(code);
//        	String token = service.retrieveAccessToken();
        	label2.setValue("Access token: " + token);
        });
        
        Button testFileButton = new Button("Send test file");
        testFileButton.addClickListener(e -> {
        	File f;
			try {
				f = File.createTempFile("test", ".txt");
	        	service.postFileToDropBox(f);
	        	f.deleteOnExit();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        layout.addComponents(button, label, tokenButton, label2, testFileButton);
        
        setContent(layout);
    }

	@WebServlet(urlPatterns = "/*", name = "UserInterfaceServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = UserInterface.class, productionMode = false)
    public static class UserInterfaceServlet extends VaadinServlet {
    }
}
