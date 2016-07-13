/**
 * 
 */
$(document).ready(function() {
	$('.agregarProvincia').off('click').on('click', function() {
		$.ajax({
			url : 'agregarProvincia.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.agregarPais').off('click').on('click', function() {
		$.ajax({
			url : 'agregarPais.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});

	});
	$('.agregarDepartamento').off('click').on('click', function() {
		$.ajax({
			url : 'agregarDepartamento.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.agregarDistrito').off('click').on('click', function() {	
			$.ajax({
				url : 'agregarDistrito.jsp',
				success : function(data) {
					$('#seccionBase').html(data);
					$('#seccionBase div').slideDown(1000);
				}
			});
	});
	$('.editarPais').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'pais',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.editarDepartamento').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'departamento',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.editarProvincia').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'provincia',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.editarDistrito').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'seccion',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('#listaPaises').off('click').on('click', function() {
		$.ajax({
			url : 'listaPaises.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});

	});
	$('#listaDepartamentos').off('click').on('click', function() {
		$.ajax({
			url : 'listaDepartamentos.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});

	});
	$('#listaProvincias').off('click').on('click', function() {
		$.ajax({
			url : 'listaProvincias.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('#listaDistritos').off('click').on('click', function() {
		$.ajax({
			url : 'listaDistritos.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('#cargaMongo').off('click').on('click', function() {
		$.ajax({
			url : 'mongo.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('#cargaMySQL').off('click').on('click', function() {
		$.ajax({
			url : 'mysql.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});	
	$('.verPais').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'pais',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.verDepartamento').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'departamento',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.verProvincia').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'provincia',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.verDistrito').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'seccion',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('#postPais').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var direccion = $(this).attr('action');
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'POST', // define the type of HTTP verb we want to use (POST
			// for our form)
			url : direccion, // the url where we want to POST
			data : formData, // our data object
			// what type of data do we expect back from the server
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});

	$('#postDepartamento').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var direccion = $(this).attr('action');
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'POST', // define the type of HTTP verb we want to use (POST
			// for our form)
			url : direccion, // the url where we want to POST
			data : formData, // our data object
			// what type of data do we expect back from the server
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});

	$('#postProvincia').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var direccion = $(this).attr('action');
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'POST', // define the type of HTTP verb we want to use (POST
			// for our form)
			url : direccion, // the url where we want to POST
			data : formData, // our data object
			// what type of data do we expect back from the server
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});

	$('#postDistrito').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var direccion = $(this).attr('action');
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'POST', // define the type of HTTP verb we want to use (POST
			// for our form)
			url : direccion, // the url where we want to POST
			data : formData, // our data object
			// what type of data do we expect back from the server
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('.listaDepartamentosFiltroPais').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var direccion = $(this).attr('action');
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'get', // define the type of HTTP verb we want to use (POST
			// for our form)
			url : direccion, // the url where we want to POST
			data : formData, // our data object
			// what type of data do we expect back from the server
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('.listaProvinciasFiltroDepartamento').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var direccion = $(this).attr('action');
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'get', // define the type of HTTP verb we want to use (POST
			// for our form)
			url : direccion, // the url where we want to POST
			data : formData, // our data object
			// what type of data do we expect back from the server
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#postMySQL').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var direccion = $(this).attr('action');
		//var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'POST', // define the type of HTTP verb we want to use (POST
			// for our form)
			url : direccion, // the url where we want to POST
			data : new FormData($(this)[0]), // our data object
			// what type of data do we expect back from the server
			async: false,
		    cache: false,
			processData: false, // tell jQuery not to process the data
		    contentType: false, // tell jQuery not to set contentType		    
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#postMongo').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var direccion = $(this).attr('action');
		//var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'POST', // define the type of HTTP verb we want to use (POST
			// for our form)
			url : direccion, // the url where we want to POST
			data : new FormData($(this)[0]), // our data object
			// what type of data do we expect back from the server
			async: false,
		    cache: false,
			processData: false, // tell jQuery not to process the data
		    contentType: false, // tell jQuery not to set contentType		    
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#putPais').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'post', // define the type of HTTP verb we want to use
			url : 'pais2', // the url where we want to put
			data : formData, // our data object
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#putDepartamento').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'post', // define the type of HTTP verb we want to use
			url : 'departamento2', // the url where we want to put
			data : formData, // our data object
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#putProvincia').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'post', // define the type of HTTP verb we want to use
			url : 'provincia2', // the url where we want to put
			data : formData, // our data object
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#putDistrito').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'post', // define the type of HTTP verb we want to use
			url : 'distrito2', // the url where we want to put
			data : formData, // our data object
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('.eliminarPais').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'pais2',
			data : {
				"id" : $(this).attr('data-index-number')
			}, // our data object
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.eliminarDepartamento').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'departamento2',
			data : {
				"id" : $(this).attr('data-index-number')
			}, // our data object
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.eliminarProvincia').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'provincia2',
			data : {
				"id" : $(this).attr('data-index-number')
			}, // our data object
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});
	$('.eliminarDistrito').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'distrito2',
			data : {
				"id" : $(this).attr('data-index-number')
			}, // our data object
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccionBase div').slideDown(1000);
			}
		});
	});	
});
