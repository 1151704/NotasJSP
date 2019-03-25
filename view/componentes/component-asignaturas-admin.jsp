<%@page import="java.util.List"%>
<%@include file="../include/validate.jsp"%>
<div class="main main-raised">
	<div class="container pt-5" id="asignaturas">
	    <div class="about-description">
	        <div class="row">
	            <div class="col-md-12 text-center">
	                <h5 class="description">Administración de asignaturas</h5>
	            </div>
	        </div>
	        <button type="button" class="btn btn-success mb-4" data-toggle="modal"
	            data-target="#asignaturaRegistrarModal">
	            <i class="material-icons">add</i> Agregar
	        </button>
	        <div class="row">
	        	<% List<Asignatura> asignaturas = controlador.asignaturaPorUsuario(usuarioActual.getId()); %>            	
		     	<% if (asignaturas != null && !asignaturas.isEmpty()) { %>
		     	<% for (Asignatura asignatura : asignaturas) { %>
	            <!-- asignatura -->
	            <div class="col-12">
	                <div class="card card-nav-tabs">
	                    <h4 class="card-header card-header-info">
	                        <a href="AsignaturaEliminar?id=<%=asignatura.getId()%>" class="btn btn-just-icon btn-sm btn-outline close link-ajax" title="Eliminar asignatura">
	                            <i class="material-icons">delete</i>
	                        </a>
	                        <a class="btn btn-just-icon btn-sm btn-outline close" title="Editar asignatura" >
	                            <i class="material-icons">edit</i>
	                        </a>
	                        <%=asignatura.getNombre()%>
	                    </h4>
	                    <!-- notas asignatura -->
	                    <div class="card-body">
	                    	<% for (AsignaturaNota nota : asignatura.getNotas()) { %>
	                        <div class=" row align-items-end">
	                            <div class="col-md-6 "><%=nota.getNombre()%></div>
	                            <div class="col-md-4 ">
	                                <input type="email" class="form-control form-control-sm text-center"
	                                    placeholder="Nota">
	                            </div>
	                            <div class="col-md-2 text-right "><%=nota.getPorcentaje()%> %</div>
	                        </div>
	                        <%} %>
	                    </div>
	                    <!-- end notas asignatura -->
	                </div>
	            </div>
	            <!-- end asignatura -->
	            <% } %>
				<% } else { %>
				<div class="col-12">
				    <div class="card">
				        <div class="card-body">
				            <h4 class="card-title">Sin asignaturas registradas</h4>
				         </div>
				    </div>
				</div>
				<% } %>
            </div>
        </div>
    </div>
</div>