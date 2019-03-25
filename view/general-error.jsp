<%
	String error = request.getParameter("error");

	String ruta = request.getContextPath() + "/";
	session.setAttribute("paginaActual", error);
	
	String textError = "";
	switch(error) {
	case "401":
		textError = "¡Oops! ¡No tiene permisos para estar aquí!";
		break;
	case "403":
		textError = "¡Oops! ¡No tiene permisos para estar aquí!";
		break;
	case "404":
		textError = "¡Oops! ¡La página que solicitó no fue encontrada!";
		break;
	case "500":
		textError = "¡Oops! ¡Error interno del servidor!";
		break;
	case "503":
		textError = "¡Oops! ¡Servicio no disponible!";
		break;
	default:
		textError = "Error desconocido, por favor cominiquese con el administrador";
		break;
	}
%>
<% session.setAttribute("paginaActual", "Error: "+ error); %>
<!doctype html>
<html lang="es">
<head>
	<jsp:include page="include/design-resources.jsp" flush="true" />
</head>
<body>
	<nav class="navbar navbar-color-on-scroll navbar-transparent fixed-top navbar-expand-lg" color-on-scroll="100">
        <div class="container">
            <div class="navbar-translate">
                <a class="navbar-brand" href="<%=ruta%>inicio.jsp">
                    Notas App</a>
            </div>
        </div>
    </nav>
    
    <div class="page-header header-filter header-" data-parallax="true"
        style="background-image: url('<%=ruta%>assets/img/bg3.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-md-8 ml-auto mr-auto">
                    <div class="brand text-center">
                        <h1><%=error %></h1>
                        <h3 class="title text-center"><%=textError%></h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
	<jsp:include page="include/interaction-resources.jsp" flush="true" />
</body>
</html>