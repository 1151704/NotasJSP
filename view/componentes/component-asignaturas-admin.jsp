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
	                        <a href="AsignaturaEliminar?id=<%=asignatura.getId()%>" class="btn btn-just-icon btn-sm btn-outline close link-ajax link-ajax-confirm" title="Eliminar asignatura">
	                            <i class="material-icons">delete</i>
	                        </a>
	                        <a href="asignatura.jsp?id=<%=asignatura.getId()%>" class="btn btn-just-icon btn-sm btn-outline close" title="Editar asignatura" >
	                            <i class="material-icons">edit</i>
	                        </a>
	                        <%=asignatura.getNombre()%>
	                    </h4>
	                    <!-- notas asignatura -->
	                    <div class="card-body">
	                    	<button type="button" class="btn btn-info btn-outline-info" title="Promedio total">
                            	 Promedio total <span class="badge badge-default"><%=asignatura.getPromedioTotal()%></span>
                            </button>
	                    	<% for (AsignaturaNota nota : asignatura.getNotas()) { %>
	                        <div class=" row align-items-end">
	                            <div class="col-md-8 "><%=nota.getNombre()%></div>
	                            <div class="col-md-2 text-center"><%=nota.getNota()%></div>
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