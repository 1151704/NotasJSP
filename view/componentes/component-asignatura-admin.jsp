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
<% if (asignatura != null && asignatura.getUsuario() != null && asignatura.getUsuario().equals(usuarioActual)) { %>
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
                            <h4 class="card-title">
                            Notas
                            </h4>
                            <div class="card-text">                            	
	                            <button type="button" class="btn btn-info btn-outline-info" title="Promedio total">
	                            	 Promedio total <span class="badge badge-default"><%=asignatura.getPromedioTotal()%></span>
	                            </button>
                            
	                            <form class="form-ajax" action="AsignaturaNotaEditar" method="post" >
	                            	<input type="hidden" value="<%=asignatura.getId()%>" name="asignatura">
		                            <div class="card-text">
		                            	<% for (AsignaturaNota nota : asignatura.getNotas()) { %>
		                            	<input type="hidden" value="<%=nota.getNota()%>" name="nota-old">
		                            	<input type="hidden" value="<%=nota.getPorcentaje()%>" name="porcentaje-old">
	                                   	<input type="hidden" value="<%=nota.getNombre()%>" name="nombre">
		                            	<!-- nota -->
		                                <div class=" row align-items-end">
		                                    <div class="col-md-6 "><%=nota.getNombre()%></div>
		                                    <div class="col-md-4 ">	                                    	
		                                        <input type="text" class="form-control form-control-sm text-center"
		                                        	value="<%=(nota.getNota() > 0 ? nota.getNota() : "")%>" 
		                                        	name="nota"
		                                            placeholder="Nota">
		                                    </div>
		                                    <div class="col-md-2 ">
		                                    	<input type="text" class="form-control form-control-sm text-center"
		                                        	value="<%=(nota.getPorcentaje() > 0 ? nota.getPorcentaje() : "")%>" 
		                                        	name="porcentaje"
		                                            placeholder="Porc"></div>
		                                </div>
		                                <!-- end nota -->
		                                <% } %>
		                            </div>
	                                <button type="submit" class="btn btn-primary">Guardar cambios</button>	                            
	                            </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<% } else { %>
<div class="main main-raised">
    <div class="container pt-5">
        <div class="about-description">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">
                            	Error
                            </h4>
                            <div class="card-text">
                            	La asignatura puede que no exista o no tengas permisos para ingresar aquí
                            </div>
                        </div>
                   	</div>
                </div>
            </div>
        </div>
    </div>
</div>
<% } %>