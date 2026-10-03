
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			response.setContentType("text/html; charset=ISO-8859-1");
			// response.setCharacterEncoding("text/html");
			PrintWriter out = response.getWriter();

			String n = request.getParameter("userName");
			//validación para nombre vacio o solo espacios.
			if (n == null || n.trim().isEmpty()) {
				out.println("Debe ingresar un nombre.");
				return;
			}
			
			String edad = request.getParameter("edad");
			//validación para edad vacio o con espacios
			if (edad == null || edad.trim().isEmpty()) {
				out.println("Debe ingresar la edad");
				return;
			}
			
			//convertir edad y validar que sea un numero
			int edadNumero;
			try {
				edadNumero = Integer.parseInt(edad);
			} catch (NumberFormatException e) {
				out.println("La edad debe ser un número.");
				return;
			}
			
			//validacion para que este dentro de un rango de 1 y 110 años
			if (edadNumero < 1 || edadNumero > 110) {
			    out.print("La edad debe estar entre 1 y 110 años.");
			    return;
			}
			
			String genero = request.getParameter("genero");
			//validar que genero sea selecionado
			if (genero == null || genero.isEmpty()) {
			    out.print("Debe seleccionar un género.");
			    return;
			}
			
			String ciudad = request.getParameter("ciudad");
			//validar que ciudad no este vacia ni con espacios
			if (ciudad == null || ciudad.trim().isEmpty()) {
			    out.print("Debe ingresar la ciudad.");
			    return;
			}
			
			String estudiante = request.getParameter("estudiante");
			if (estudiante == null) {
				estudiante = "false";
			}
			
			out.print("Welcome " + n);

			Cookie ck = new Cookie("uname", n);// creating cookie object
			response.addCookie(ck);// adding cookie in the response
			
			Cookie ckEdad = new Cookie("age", edad);
			response.addCookie(ckEdad);
			
			Cookie ckGenero = new Cookie("gender", genero);
			response.addCookie(ckGenero);
			
			Cookie ckCiudad = new Cookie("city", ciudad);
			response.addCookie(ckCiudad);
			
			Cookie ckEstudiante = new Cookie("student", estudiante);
			response.addCookie(ckEstudiante);
			
			// creating submit button
			out.print("<form action='Servlet2' method='post'>");
			out.print("<input type='submit' value='go'>");
			out.print("</form>");

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
