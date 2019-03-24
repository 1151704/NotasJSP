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

@WebServlet(urlPatterns = { "/UsuarioRegistrar" })
public class UsuarioRegistrar extends HttpServlet {

	private HttpSession session;
	private PrintWriter out;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		out = response.getWriter();

		session = request.getSession();
		Controlador controlador = (Controlador) session.getAttribute("controlador");

		if (controlador == null) {
			controlador = new Controlador();
			session.setAttribute("controlador", controlador);
		}

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String password = request.getParameter("password");

		controlador.usuarioRegistrar(nombre, apellido, username, email, telefono, password);

		Usuario usuario = controlador.usuarioPorUsuario(username);
		if (usuario != null) {
			session.setAttribute("usuarioActual", usuario);

			out.write("{\"mensaje\": \"Bienvenido\", \"redirect\": \"inicio.jsp\" }");

		} else {
			session.setAttribute("usuarioActual", null);

			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("{\"mensaje\": \"El registro no se completo, por favor intenta de nuevo\"}");
		}
	}

	private static final long serialVersionUID = 1L;

}
