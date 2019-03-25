<div class="modal fade" id="asignaturaRegistrarModal" tabindex="-1" role="">
    <div class="modal-dialog modal-login" role="document">
        <div class="modal-content">
            <div class="card card-signup card-plain">
                <div class="modal-header">
                    <div class="card-header card-header-primary text-center" style="width: 100%">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="material-icons">clear</i>
                        </button>
                        <h4 class="card-title">Nueva Asignatura</h4>
                    </div>
                </div>
                <form class="form form-ajax" method="POST" action="AsignaturaRegistrar">
                	<div class="modal-body">
                        <div class="card-body">
                            <div class="form-group bmd-form-group">
                                <div class="input-group">
                                    <input type="text" name="nombre" class="form-control" placeholder="Nombre...">
                                </div>
                            </div>
                            <div class="form-group bmd-form-group">
                                <div class="input-group">
                                    <input type="text" name="profesor" class="form-control"
                                        placeholder="Profesor...">
                                </div>
                            </div>
                            <div class="form-group bmd-form-group">
                                <div class="input-group">
                                    <input type="number" name="creditos" class="form-control"
                                        placeholder="Créditos...">
                                </div>
                            </div>
                        </div>
	                </div>
	                <div class="modal-footer justify-content-center">
	                    <input type="submit" class="btn btn-primary btn-link btn-wd btn-lg" value="Guardar">
	                </div>
                </form>
            </div>
        </div>
    </div>
</div>