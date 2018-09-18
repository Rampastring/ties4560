package dropbox_servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.NoSuchFileException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Demo2_2_as_dynamic_web_project.*;

/**
 * Servlet implementation class MyConvertor_Servlet
 */
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		DropBoxService dropbox = new DropBoxService();
		PrintWriter out = response.getWriter();
		
		String result = "";
		
		String action = request.getParameter("action");
		
		String token = request.getParameter("access_token");
		
		if(token != null)
			dropbox.setToken(token);
		
		switch(action){
		case "create_token":
			try {
				result = dropbox.retrieveAccessTokenUri();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "upload_file":				
			String filepath = request.getParameter("file_path");
			
			if(filepath.length() == 0)
			{
				result = "no filepath specified!";
				break;
			}
			
			File testfile = new File(filepath);
			
			result = dropbox.postFileToDropBox(testfile);
			
			if(result.length() == 0)
				result = "failed to upload file!";
			
			break;
			
		case "get_user_info":		
			result = dropbox.getAccountInformation();
			break;
			
		case "create_new_folder":
			String folderPath = request.getParameter("folder_path");
			result = dropbox.createNewFolder(folderPath);
			break;
			
		default:
			result = "invalid action!";		
		}
		
		
		out.write(result); 	
					 
		out.flush();
	    out.close();

	}

}
