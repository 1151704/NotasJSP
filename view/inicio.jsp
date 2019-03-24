<% session.setAttribute("paginaActual", "Notas App"); %>
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
                        <a href="asignaturas.html" class="nav-link">
                            Asignaturas
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="usuario.html" class="nav-link">
                            Mi cuenta
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="Signup" class="nav-link">
                            Logout
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    
    <div class="page-header header-filter header-small" data-parallax="true"
        style="background-image: url('assets/img/bg9.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-md-8 ml-auto mr-auto text-center">
                    <h1 class="title">Notas App</h1>
                    <h4>Bienvenido Omar</h4>
                </div>
            </div>
        </div>
    </div>
    
    <div class="main main-raised">
        <div class="container">
            <div class="about-description text-center">
                <div class="row">
                    <div class="col-md-8 ml-auto mr-auto">
                        <h5 class="description">Descripción de Asignaturas</h5>
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Asignatura 1</h4>
                                <h6 class="card-subtitle mb-2 text-muted"># creditos</h6>
                                <p class="card-text">
                                    <button class="btn btn-round btn-sm">
                                        4.00
                                    </button>
                                </p>
                                <a href="asignatura.html" class="btn btn-primary">Ver notas</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Asignatura 2</h4>
                                <h6 class="card-subtitle mb-2 text-muted"># creditos</h6>
                                <p class="card-text">
                                    <button class="btn btn-round btn-sm">
                                        4.00
                                    </button>
                                </p>
                                <a href="asignatura.html" class="btn btn-primary">Ver notas</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Asignatura 3</h4>
                                <h6 class="card-subtitle mb-2 text-muted"># creditos</h6>
                                <p class="card-text">
                                    <button class="btn btn-round btn-sm">
                                        4.00
                                    </button>
                                </p>
                                <a href="asignatura.html" class="btn btn-primary">Ver notas</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Asignatura 4</h4>
                                <h6 class="card-subtitle mb-2 text-muted"># creditos</h6>
                                <p class="card-text">
                                    <button class="btn btn-round btn-sm">
                                        4.00
                                    </button>
                                </p>
                                <a href="asignatura.html" class="btn btn-primary">Ver notas</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Asignatura 5</h4>
                                <h6 class="card-subtitle mb-2 text-muted"># creditos</h6>
                                <p class="card-text">
                                    <button class="btn btn-round btn-sm">
                                        4.00
                                    </button>
                                </p>
                                <a href="asignatura.html" class="btn btn-primary">Ver notas</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
 
    <jsp:include page="include/footer.jsp" flush="true" />
    
	<jsp:include page="include/interaction-resources.jsp" flush="true" />
</body>
</html>