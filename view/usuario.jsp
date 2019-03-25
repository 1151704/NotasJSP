<% session.setAttribute("paginaActual", "Mi cuenta | Notas App"); %>
<%@include file="../include/validate.jsp"%>
<!doctype html>
<html lang="es">
<head>
	<jsp:include page="include/design-resources.jsp" flush="true" />
</head>
<body>   

	<jsp:include page="include/component-header-nav.jsp" flush="true" />
    
    <div class="page-header header-filter header-small" data-parallax="true"
        style="background-image: url('resource/img/city-profile.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-md-8 ml-auto mr-auto text-center">
                    <h1 class="title">Mi cuenta</h1>
                </div>
            </div>
        </div>
    </div>
    
    <div id="component-usuario-admin"></div>
    
    <jsp:include page="include/footer.jsp" flush="true" />
    
	<jsp:include page="include/interaction-resources.jsp" flush="true" />
</body>
</html>