
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			response.setContentType("text/html; charset=ISO-8859-1");
			PrintWriter out = response.getWriter();

			Cookie[] cookies = request.getCookies();
			
			String n = null;
			String edad = null;
			String genero = null;
			String ciudad = null;
			String estudiante = null;
			
			if(cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("uname")) {
						n = cookie.getValue();
					} 
					if (cookie.getName().equals("age")) {
						edad = cookie.getValue();
					} 
					if (cookie.getName().equals("gender")) {
						genero = cookie.getValue();
						} 
					if (cookie.getName().equals("city")) {
						ciudad = cookie.getValue();
						} 
					if (cookie.getName().equals("student")) {
						estudiante = cookie.getValue();
						}
				}
			}
			
			out.print("Hello " + n + "</p>");
			out.print("<p>Edad: " + edad + "</p>");
			out.print("<p>Género: " + genero + "</p>");
			out.print("<p>Ciudad: " + ciudad + "</p>");
			out.print("<p>¿Es estudiante?: " + estudiante + "</p>");

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
