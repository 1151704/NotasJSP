const URL = getAbsolutePath();
const COMPONENTES = [
	{id: "component-asignaturas-admin", funcion: "listadoAsignaturas"},
	{id: "component-asignatura-admin", funcion: "adminAsignatura"},
	{id: "component-usuario-admin", funcion: "adminUsuario"}
]

function getAbsolutePath() {
	let loc = window.location;
	let pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
	let aplicativo = loc.protocol + "//" + loc.host + "/"
			+ pathName.split("/")[1] + "/";
	return aplicativo;
}

function redirect(url) {
	window.location.href = url;
}

$(document).ready(function() {
	cargarComponentes();
	linkAjax();
	formAjax();
});

function cargarComponentes() {
	
	for (let pagina of COMPONENTES) {
		
		if (document.getElementById(pagina.id)) {
			executeFunctionByName(pagina.funcion, window);		
		}
		
	}
	
}

function formAjax() {

	$('form.form-ajax').off('submit');
	$('form.form-ajax').on('submit', function(e) {
		e.preventDefault();

		enviarData(this);
	});

	function enviarData(formulario) {
		let form = $(formulario);

		let response_ajax = $("#response-ajax");

		let respuestas = $.ajax({

			type : form.attr('method'),
			url : form.attr('action'),
			data : form.serialize(),
			success : function(response, status, xhr) {

				$(".modal").modal('hide');
				
				if (response.mensaje) {
					let msgError = response.mensaje;
									
					Swal.fire({
						  position: 'bottom-end',
						  type: 'success',
						  title: msgError,
						  showConfirmButton: false,
						  timer: 1000
						});
				}

				if (response.execute) {
					executeFunctionByName(response.execute.funcion, window,
							response.execute.argumentos);
				}
				
				form.trigger("reset");

				if (response.redirect) {
					redirect(URL + response.redirect);
				}

			},
			error : function(data) {

				let msgError = 'Error al enviar el formulario!';
				let tituloError = 'Oops...';

				if (data && data.responseJSON && data.responseJSON.mensaje) {
					msgError = data.responseJSON.mensaje;
				}

				if (data && data.responseJSON && data.responseJSON.titulo) {
					tituloError = data.responseJSON.titulo;
				}

				Swal.fire({
					type : 'error',
					title : tituloError,
					text : msgError
				});
			}
		});
	}
}

function linkAjax() {

	$(".link-ajax").off('click');
	$(".link-ajax").on('click', function(e) {
    
		if ($(this).hasClass("link-ajax-confirm")) {
			
			Swal.fire({
				  title: 'Estas seguro?',
				  type: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: 'Si',
				  cancelButtonText: 'Cancelar',
				}).then((result) => {
				  if (result.value) {
					  enviarData(this.href); 	
				  }
				})
			
		} else {
			
			enviarData(this.href); 			
			
		}
		
		return false;
	});

	function enviarData(ruta) {

		let response_ajax = $("#response-ajax");

		let respuestas = $.ajax({

			type : 'get',
			url : ruta,
			success : function(response, status, xhr) {

				$(".modal").modal('hide');
				
				if (response.mensaje) {
					let msgError = response.mensaje;
									
					Swal.fire({
						  position: 'bottom-end',
						  type: 'success',
						  title: msgError,
						  showConfirmButton: false,
						  timer: 1000
						});
				}

				if (response.execute) {
					executeFunctionByName(response.execute.funcion, window,
							response.execute.argumentos);
				}
				
				if (response.redirect) {
					redirect(URL + response.redirect);
				}

			},
			error : function(data) {

				let msgError = 'Error al enviar el formulario!';
				let tituloError = 'Oops...';

				if (data && data.responseJSON && data.responseJSON.mensaje) {
					msgError = data.responseJSON.mensaje;
				}

				if (data && data.responseJSON && data.responseJSON.titulo) {
					tituloError = data.responseJSON.titulo;
				}

				Swal.fire({
					type : 'error',
					title : tituloError,
					text : msgError
				});
			}
		});
	}
}

function executeFunctionByName(functionName, context /* , args */) {
	var args = Array.prototype.slice.call(arguments, 2);
	var namespaces = functionName.split(".");
	var func = namespaces.pop();
	for (var i = 0; i < namespaces.length; i++) {
		context = context[namespaces[i]];
	}
	return context[func].apply(context, args);
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
            results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

// Carga de componente con listado de asignaturas por usuario logedado
function listadoAsignaturas() {
	
	const componente = COMPONENTES[0];
	
	let url = "componentes/"+componente.id+".jsp";
	
	$.post(url, function (data) {
		$("#"+componente.id).html(data);
		linkAjax();
	});
}
// Carga de componente con administración de asignatura por el parametro id de la url
function adminAsignatura() {
	
	let id = getParameterByName('id');
	
	const componente = COMPONENTES[1];
	
	let url = "componentes/"+componente.id+".jsp?id="+id;
		
	$.post(url, function (data) {
		$("#"+componente.id).html(data);
		linkAjax();
		formAjax();
	});
}
// Carga de componente con administración del usuario logeado
function adminUsuario() {
		
	const componente = COMPONENTES[2];
	
	let url = "componentes/"+componente.id+".jsp";
	
	$.post(url, function (data) {
		$("#"+componente.id).html(data);
		formAjax();
	});
}