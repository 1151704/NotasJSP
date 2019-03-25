<%@page import="java.util.List"%>
<%@include file="../include/validate.jsp"%>
<div class="main main-raised">
    <div class="container">
        <div class="about-description text-center">
            <div class="row">
                <div class="col-md-8 ml-auto mr-auto">
                    <h5 class="description">Descripción de Asignaturas</h5>
                </div>
            </div>
            <div class="row justify-content-md-center">
            	<% List<Asignatura> asignaturas = controlador.asignaturaPorUsuario(usuarioActual.getId()); %>            	
            	<% if (asignaturas != null && !asignaturas.isEmpty()) { %>
            	<% for (Asignatura asignatura : asignaturas) { %>
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title"><%=asignatura.getNombre()%></h4>
                            <h6 class="card-subtitle mb-2 text-muted"><%=asignatura.getCreditos() %> créditos</h6>
                            <p class="card-text">
                                <button class="btn btn-round btn-sm">
                                    <%=asignatura.getPromedioTotal()%>
                                </button>
                            </p>
                            <a href="asignatura.jsp?id=<%=asignatura.getId()%>" class="btn btn-primary">Ver notas</a>
                        </div>
                    </div>
                </div>
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