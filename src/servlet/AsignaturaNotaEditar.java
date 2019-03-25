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

@WebServlet("/AsignaturaNotaEditar")
public class AsignaturaNotaEditar extends HttpServlet {
	
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
			
			Long id = Long.parseLong(request.getParameter("asignatura"));
			
			String[] nombre = request.getParameterValues("nombre");
			String[] notasOld = request.getParameterValues("nota-old");
			String[] notasNew = request.getParameterValues("nota");
			String[] porcentajeOld = request.getParameterValues("porcentaje-old");
			String[] porcentajeNew = request.getParameterValues("porcentaje");
			
			double nota, notaO, porcentaje, porcentajeO;
			
			for (int i = 0; i < nombre.length; i++) {

				nota = Double.parseDouble(notasNew[i]);
				notaO = Double.parseDouble(notasOld[i]);
				porcentaje = Double.parseDouble(porcentajeNew[i]);
				porcentajeO = Double.parseDouble(porcentajeOld[i]);
				
				if (nota != notaO || porcentaje != porcentajeO) {
					controlador.asignaturaNotaActualizar(nombre[i], id, nota, porcentaje);
				}
				
			}

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
