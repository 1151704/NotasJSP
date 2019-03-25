<%@include file="../include/validate.jsp"%>
<div class="main main-raised">
    <div class="container pt-5">
        <div class="about-description">
            <div class="row">
                <!-- perfil -->
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">
                                Datos básicos
                            </h4>
                            <div class="card-text">
                                <form class="form-ajax" action="UsuarioEditar" method="post">

                                    <div class="form-group">
                                        <label for="usuarioUsername">Usuario</label>
                                        <input type="text" name="usuario" id="usuarioUsername" class="form-control"
                                            value="<%=usuarioActual.getUsuario()%>" disabled>
                                    </div>
                                    <div class="form-group">
                                        <label for="usuarioNombre">Nombre</label>
                                        <input type="text" name="nombre" id="usuarioNombre" class="form-control"
                                            value="<%=usuarioActual.getNombre()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="usuarioApellido">Apellido</label>
                                        <input type="text" name="apellido" id="usuarioApellido" class="form-control"
                                            value="<%=usuarioActual.getApellido()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="usuarioTelefono">Teléfono</label>
                                        <input type="text" name="telefono" id="usuarioTelefono" class="form-control"
                                            value="<%=usuarioActual.getTelefono()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="usuarioEmail">Email</label>
                                        <input type="email" name="email" id="usuarioEmail" class="form-control"
                                            value="<%=usuarioActual.getEmail()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="usuarioPassword">Contraseña</label>
                                        <input type="password" name="password" id="usuarioPassword" class="form-control"
                                            value="<%=usuarioActual.getPassword()%>">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Guardar cambios</button>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- en perfil -->
            </div>
        </div>
    </div>
</div>