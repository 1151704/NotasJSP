const URL = getAbsolutePath();

function getAbsolutePath() {
    let loc = window.location;
    let pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
    let aplicativo = loc.protocol + "//" + loc.host + "/" + pathName.split("/")[1] + "/";
    return aplicativo;
}

function redirect(url) {
	window.location.href = url;
}

$(document).ready(function () {
	linkAjax();
	formAjax();	
});

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
        	
            type: form.attr('method'),
            url: form.attr('action'),
            data: form.serialize(),
            success: function(response, status, xhr) { 
            	
            	if (response.redirect) {
            		redirect(URL+response.redirect);
            	}
            	
            },
            error: function(data) {
            	           	
            	let msgError = 'Error al enviar el formulario!';
            	let tituloError = 'Oops...';
            	
            	if (data && data.responseJSON && data.responseJSON.mensaje) {
            		msgError = data.responseJSON.mensaje;
            	}

            	if (data && data.responseJSON && data.responseJSON.titulo) {
            		tituloError= data.responseJSON.titulo;
            	}
            	
            	Swal.fire({
            		  type: 'error',
            		  title: tituloError,
            		  text: msgError
    			  });
            }
        });
    }
}

function linkAjax() {
    
	$('*.link-ajax').off('click');
    $('*.link-ajax').on('click', function(e) {
        e.preventDefault();
        
        enviarData(this.href);
    });


    function enviarData(ruta) {
    	        
    	let response_ajax = $("#response-ajax");

    	let respuestas = $.ajax({
        	
            type: 'get',
            url: ruta,
            success: function(response, status, xhr) { 
            	
            	if (response.redirect) {
            		redirect(URL+response.redirect);
            	}
            	
            },
            error: function(data) {
            	           	
            	let msgError = 'Error al enviar el formulario!';
            	let tituloError = 'Oops...';
            	
            	if (data && data.responseJSON && data.responseJSON.mensaje) {
            		msgError = data.responseJSON.mensaje;
            	}

            	if (data && data.responseJSON && data.responseJSON.titulo) {
            		tituloError= data.responseJSON.titulo;
            	}
            	
            	
            	Swal.fire({
            		  type: 'error',
            		  title: tituloError,
            		  text: msgError
    			  });
            }
        });
    }
}