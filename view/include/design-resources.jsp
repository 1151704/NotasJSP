<%
	String ruta = request.getContextPath() + "/";

	String paginaActual = (String) session.getAttribute("paginaActual");
	if (paginaActual == null) {
		paginaActual = "Notas App";
	}
%>
<title><%=paginaActual%></title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- Material Kit CSS -->
<link href="<%=ruta%>assets/css/material-kit.css?v=2.0.5"
	rel="stylesheet" />
<link rel="shortcut icon" href="<%=ruta%>icon/icon.png"
	type="image/x-icon">