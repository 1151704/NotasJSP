package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Asignatura;
import dto.Usuario;
import servicio.Controlador;

@WebServlet("/AsignaturaEliminar")
public class AsignaturaEliminar extends HttpServlet {

	private HttpSession session;
	private PrintWriter out;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		out = response.getWriter();

		session = request.getSession();
		Controlador controlador = (Controlador) session.getAttribute("controlador");

		Usuario usuarioActual = (Usuario) session.getAttribute("usuarioActual");

		if (usuarioActual != null) {
			
			Long id = Long.parseLong(request.getParameter("id"));
			String componente = request.getParameter("type");
			
			Asignatura asignatura = controlador.asignaturaPorId(id);
		
			if (asignatura != null && asignatura.getUsuario() != null && asignatura.getUsuario().equals(usuarioActual)) {

				controlador.asignaturaEliminar(id);
				if (componente == null) {
				out.write("{"
						+ "\"mensaje\": \"Hecho\","
						+ "\"execute\": {"
						+ "\"funcion\": \"listadoAsignaturas\""
						+ "}}");
				} else {
					out.write("{"
							+ "\"mensaje\": \"Hecho\","
							+ "\"redirect\": \"asignaturas.jsp\""
							+"}");
				}
				
			} else {				
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				out.write("{\"mensaje\": \"No tienes permisos para eliminar esta asignatura\", \"redirect\": \"asignaturas.jsp\"}");
			}

		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("{\"mensaje\": \"Sin sessión\"}");
		}
		
	}
	
	private static final long serialVersionUID = 1L;

}
