package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Usuario;
import servicio.Controlador;

@WebServlet("/AsignaturaEditar")
public class AsignaturaEditar extends HttpServlet {

	private HttpSession session;
	private PrintWriter out;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		out = response.getWriter();

		session = request.getSession();
		Controlador controlador = (Controlador) session.getAttribute("controlador");

		Usuario usuarioActual = (Usuario) session.getAttribute("usuarioActual");

		if (usuarioActual != null) {
			
			String nombre = request.getParameter("nombre");
			String profesor = request.getParameter("profesor");
			int creditos = Integer.parseInt(request.getParameter("creditos"));
			Long id = Long.parseLong(request.getParameter("id"));

			controlador.asignaturaActualizar(id, nombre, creditos, profesor, usuarioActual.getId());

			out.write("{"
					+ "\"mensaje\": \"Hecho\","
					+ "\"execute\": {"
					+ "\"funcion\": \"adminAsignatura\""
					+ "}}");

		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("{\"mensaje\": \"Sin sessión\"}");
		}		
		
	}

	private static final long serialVersionUID = 1L;
	
}
