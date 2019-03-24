<%@page import="dto.Usuario"%>
<% session.setAttribute("paginaActual", "Notas App"); %>
<% Usuario usuarioActual = (Usuario) session.getAttribute("usuarioActual"); %>
<% if (usuarioActual == null) { %>
<!doctype html>
<html lang="es">
<head>
	<jsp:include page="include/design-resources.jsp" flush="true" />
</head>
<body>
	<nav class="navbar navbar-color-on-scroll navbar-transparent fixed-top navbar-expand-lg" color-on-scroll="100">
        <div class="container">
            <div class="navbar-translate">
                <a class="navbar-brand" href="index.html">
                    Notas App</a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="navbar-toggler-icon"></span>
                    <span class="navbar-toggler-icon"></span>
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>

            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a href="#" class="nav-link" data-toggle="modal" data-target="#registerModal">
                            Register <i class="material-icons">assignment</i>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link" data-toggle="modal" data-target="#loginModal">
                            Login <i class="material-icons">assignment</i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
    <div class="page-header header-filter" data-parallax="true"
        style="background-image: url('assets/img/bg3.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-md-8 ml-auto mr-auto">
                    <div class="brand text-center">
                        <h1>Notas App</h1>
                        <h3 class="title text-center">Sistema histórico de notas académicas</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="main main-raised">
        <div class="container">
            <div class="section text-center">
                <h2 class="title">Omar Ramón Montes</h2>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header card-header-text card-header-primary">
                            <div class="card-text">
                                <h4 class="card-title">Tecnólogo ADSI</h4>
                            </div>
                        </div>
                        <div class="card-body">
                            Egresado del SENA, con el título de Tecnólogo en Análisis y Desarrollo de Sistemas de
                            Información.
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header card-header-text card-header-primary">
                            <div class="card-text">
                                <h4 class="card-title">Ingenieria de Sistemas</h4>
                            </div>
                        </div>
                        <div class="card-body">
                            Estudiante de Cuarto semestre de Ingenieria de Sistemas de la Universidad Francisco de Paula
                            Santander.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <jsp:include page="include/modal-login.jsp" flush="true" />
    
    <jsp:include page="include/modal-register.jsp" flush="true" />
    
    <jsp:include page="include/footer.jsp" flush="true" />
    
	<jsp:include page="include/interaction-resources.jsp" flush="true" />
</body>
</html>
<% }  else { %>
<script>window.location.href="inicio.jsp"</script>
<% } %>