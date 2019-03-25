const URL = getAbsolutePath();
const COMPONENTES = [
	{id: "component-asignaturas-admin", funcion: "listadoAsignaturas"}
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
	linkAjax();
	formAjax();
	cargarComponentes();
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
    
		enviarData(this.href);  
		
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

// Carga de componente con listado de asignaturas por usuario logedado
function listadoAsignaturas() {
	
	let url = "componentes/"+COMPONENTES[0].id+".jsp";
	
	$.post(url, function (data) {
		$("#"+COMPONENTES[0].id).html(data);
		linkAjax();
	});
}