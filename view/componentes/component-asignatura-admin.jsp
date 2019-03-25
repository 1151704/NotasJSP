<%@page import="java.util.List"%>
<%@include file="../include/validate.jsp"%>
<% Long id = 0l;%>
<%
	try{ 
		id = Long.parseLong(request.getParameter("id"));
	} catch(Exception e) {
	}
%>
<% Asignatura asignatura = controlador.asignaturaPorId(id); %>
<% if (asignatura != null) { %>
<div class="main main-raised">
    <div class="container pt-5">
        <div class="about-description">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="AsignaturaEliminar?id=<%=asignatura.getId()%>&type=componente" class="btn btn-outline-danger btn-just-icon close link-ajax link-ajax-confirm"
                                    data-dismiss="modal" aria-hidden="true">
                                    <i class="material-icons ">delete</i>
                                </a>
                                Datos básicos
                            </h4>
                            <div class="card-text">
                                <form class="form-ajax" action="AsignaturaEditar" method="post">
									<input type="hidden" name="id" value="<%=asignatura.getId()%>">
                                    <div class="form-group">
                                        <label for="asignaturaNombre">Nombre</label>
                                        <input type="text" name="nombre" id="asignaturaNombre" class="form-control"
                                            value="<%=asignatura.getNombre()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="asignaturaProfesor">Profesor</label>
                                        <input type="text" name="profesor" id="asignaturaProfesor"
                                            class="form-control" value="<%=asignatura.getProfesor()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="asignaturaCreditos">Créditos</label>
                                        <input type="text" name="creditos" id="asignaturaCreditos"
                                            class="form-control" value="<%=asignatura.getCreditos()%>">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Guardar cambios</button>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Notas</h4>
                            <div class="card-text">
                            	<!-- nota -->
                                <div class=" row align-items-end">
                                    <div class="col-md-6 ">Nota 1</div>
                                    <div class="col-md-4 ">
                                        <input type="email" class="form-control form-control-sm text-center"
                                            placeholder="Nota">
                                    </div>
                                    <div class="col-md-2 text-right ">23.3 %</div>
                                </div>
                                <!-- end nota -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<% } else { %>
<% } %>