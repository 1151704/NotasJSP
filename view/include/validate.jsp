<%@page import="conexion.Conexion"%>
<%@page import="dto.*"%>
<jsp:useBean id="controlador" scope="session"
	class="servicio.Controlador" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	Usuario usuarioActual = (Usuario) session.getAttribute("usuarioActual");
	String rutaApp = request.getContextPath()+"/";

	boolean conexion = Conexion.getCnn() != null;

	if (!conexion || usuarioActual == null) {
%>
<script>
	window.location.href = "<%=rutaApp + "index.jsp"%>";
</script>
<%}%>