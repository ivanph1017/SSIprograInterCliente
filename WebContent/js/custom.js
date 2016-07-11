/**
 * 
 */
$(document).ready(function() {
	$('#gestionAcademica').off('click').on('click', function() {
		$.ajax({
			url : 'gestionAcademica.jsp',
			success : function(data) {
				$('#asideBase').html(data);
				$('#aside div').slideDown(1000);
			}
		});
		$.ajax({
			url : 'blank.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccion div').slideDown(1000);
			}
		});
	});
	$('#gestionEventos').off('click').on('click', function() {
		$.ajax({
			url : 'gestionEventos.jsp',
			success : function(data) {
				$('#asideBase').html(data);
				$('#aside div').slideDown(1000);
			}
		});
		$.ajax({
			url : 'blank.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccion div').slideDown(1000);
			}
		});
	});
	$('#gestionContable').off('click').on('click', function() {
		$.ajax({
			url : 'gestionContable.jsp',
			success : function(data) {
				$('#asideBase').html(data);
				$('#aside div').slideDown(1000);
			}
		});
		$.ajax({
			url : 'blank.jsp',
			success : function(data) {
				$('#seccionBase').html(data);
				$('#seccion div').slideDown(1000);
			}
		});
	});
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
	$('.agregarSeccion').off('click').on('click', function() {
		if ($('body')) {
			$.ajax({
				url : 'agregarSeccion.jsp',
				success : function(data) {
					$('#seccionBase').html(data);
					$('#seccionBase div').slideDown(1000);
				}
			});
		} else {
			$.ajax({
				url : 'agregarSeccion.jsp',
				success : function(data) {
					$('#divDinamico').html(data);
					$('#divDinamico div').slideDown(1000);
				}
			});
		}

	});
	$('.asignarAlumnosASeccion').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'alumnoSeccion',
			data : {
				"id" : $(this).attr('data-index-number')
			},
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('.asignarNotasAlumnoSeccion').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'notaSeccion',
			data : {
				"id" : $(this).attr('data-index-number')
			},
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('#confirmar').off('click').on('click', function() {
		if ($('body')) {
			$.ajax({
				url : 'confirmarProfesor.jsp',
				success : function(data) {
					$('#seccionBase').html(data);
					$('#seccionBase div').slideDown(1000);
				}
			});
		} else {
			$.ajax({
				url : 'confirmarProfesor.jsp',
				success : function(data) {
					$('#divDinamico').html(data);
					$('#divDinamico div').slideDown(1000);
				}
			});
		}
	});
	$('.editarAlumno').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'alumno',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('.editarCurso').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'curso',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('.editarProfesor').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'profesor',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('.editarSeccion').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'seccion',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
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
	$('#listaSecciones').off('click').on('click', function() {
		if ($('body')) {
			$.ajax({
				url : 'listaSecciones',
				success : function(data) {
					$('#seccionBase').html(data);
					$('#seccionBase div').slideDown(1000);
				}
			});
		} else {
			$.ajax({
				url : 'listaSecciones',
				success : function(data) {
					$('#divDinamico').html(data);
					$('#divDinamico div').slideDown(1000);
				}
			});
		}
	});
	$('.verAlumno').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'alumno',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('.verCurso').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'curso',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('.verProfesor').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'profesor',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('.verSeccion').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'seccion',
			data : {
				"id" : $(this).attr('data-index-number'),
				"action" : $(this).attr('data-action')
			},
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('#postAlumno').off('submit').on('submit', function(event) {
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
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});

	$('#postProfesor').off('submit').on('submit', function(event) {
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
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});

	$('#postCurso').off('submit').on('submit', function(event) {
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
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});

	$('#postSeccion').off('submit').on('submit', function(event) {
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
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#putAlumno').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'post', // define the type of HTTP verb we want to use
			url : 'alumno2', // the url where we want to put
			data : formData, // our data object
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#putProfesor').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'post', // define the type of HTTP verb we want to use
			url : 'profesor2', // the url where we want to put
			data : formData, // our data object
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#putCurso').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'post', // define the type of HTTP verb we want to use
			url : 'curso2', // the url where we want to put
			data : formData, // our data object
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#putSeccion').off('submit').on('submit', function(event) {
		event.stopPropagation();
		var formData = $(this).serializeArray();
		// process the form
		$.ajax({
			type : 'post', // define the type of HTTP verb we want to use
			url : 'seccion2', // the url where we want to put
			data : formData, // our data object
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('.eliminarAlumno').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'alumno2',
			data : {
				"id" : $(this).attr('data-index-number')
			}, // our data object
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('.eliminarProfesor').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'profesor2',
			data : {
				"id" : $(this).attr('data-index-number')
			}, // our data object
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('.eliminarCurso').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'curso2',
			data : {
				"id" : $(this).attr('data-index-number')
			}, // our data object
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('.eliminarSeccion').off('click').on('click', function() {
		$.ajax({
			type : 'get',
			url : 'seccion2',
			data : {
				"id" : $(this).attr('data-index-number')
			}, // our data object
			success : function(data) {
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		});
	});
	$('#postAlumnoSeccion').off('submit').on('submit', function(event) {
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
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});
	$('#postNotasSeccion').off('submit').on('submit', function(event) {
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
				$('#divDinamico').html(data);
				$('#divDinamico div').slideDown(1000);
			}
		})
		// stop the form from submitting the normal way and refreshing the page
		event.preventDefault();
	});

});
