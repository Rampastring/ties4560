package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.NameGeneratorClient;
import localhost._8080.namegenerator.Gender;

/**
 * Servlet implementation class
 */
@WebServlet("/GenerateFullName")
public class FullNameGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FullNameGenerator() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String genderString = request.getParameter("gender");
		String name = "";
		Gender gender = Gender.FEMALE;
		if (genderString != null && !genderString.equals("female")) {
			if (genderString.equals("male"))
				gender = Gender.MALE;
			else {
				writeError(out, "Unknown gender " + genderString, response);
				return;
			}
		}
	
		NameGeneratorClient client = new NameGeneratorClient();
		name = client.getFullName(gender);
		
		out.write(name);
		out.flush();
		out.close();
	}
	
	private void writeError(PrintWriter writer, String message, HttpServletResponse response) {
		response.setStatus(400);
		writer.write(message);
		writer.flush();
		writer.close();
	}
}
