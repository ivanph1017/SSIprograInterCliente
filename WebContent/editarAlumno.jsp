<%@page import="requestsresponses.Colegio"%>
<%@page import="java.util.List"%>
<%@page import="requestsresponses.AlumnoResponse"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="bootstrap-3.3.6-dist/css/bootstrap.min.css" />
<script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
<script src="js/jquery-2.2.3.js"></script>
<link rel="stylesheet" href="css/custom2.css" />
<script src="js/custom.js">
	
</script>
<title>Panel de control</title>
</head>
<body>
	<div id="divDinamico" class="container-fluid">
		<h4 class="section-titulo">Gestión de Alumnos / Editar Alumno</h4>
		<form id="putAlumno">
		<%AlumnoResponse alumno=(AlumnoResponse) request.getAttribute("alumno"); %>
			<div class="row">
				<div class="form-group col-md-2" style="center">
					<label for="nombre">Nombre</label> <input type="text"
						class="form-control" id="nombreEditarAlumno"
						name="nombre" value="<%=alumno.getNombres()%>">
				</div>
				<div class="form-group col-md-4" style="center">
					<label for="apellidopaterno">Apellido Paterno</label> <input
						type="text" class="form-control" id="apellidoPaternoEditarAlumno"
						 name="apellidop"
						value="<%=alumno.getApellido_paterno()%>">
				</div>
				<div class="form-group col-md-4" style="center">
					<label for="apellidomaterno">Apellido Materno</label> <input
						type="text" class="form-control" id="apellidoMaternoEditarAlumno"
						name="apellidom"
						value="<%=alumno.getApellido_materno()%>">
				</div>
				<div class="form-group col-md-2" style="center">
					<label for="dni">DNI</label> <input type="text"
						class="form-control" id="dniEditarAlumno"
						name="dni" value="<%=alumno.getDni()%>">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-2" style="center">
					<label for="codigo">Código</label> <input type="number"
						class="form-control" id="codigoEditarAlumno"
						name="codigo" value="<%=alumno.getCodigo()%>">
				</div>
				<div class="form-group col-md-4" style="center">
					<label for="urlfoto">URL Foto</label> <input type="url"
						class="form-control" id="urlfotoEditarAlumno"
						name="urlfoto"
						value="<%=alumno.getFoto_url()%>">
				</div>
				<div class="form-group col-md-3" style="center">
					<label for="colegio">Colegio</label> <select id="colegioEditarAlumno"
						class="form-control" name="colegio">
						<%List<Colegio> colegios = (List<Colegio>) request.getSession().getAttribute("colegios"); 
						for(Colegio cole : colegios){				
						%>
						<option value="<%=cole.getId()%>"><%=cole.getNombre() %></option>
						<%}%>
					</select>
				</div>
				 <input type="hidden"
						class="form-control" id="idEditarAlumno"
						name="id"
						value="<%=alumno.getId()%>">
				<div class="col-md-3" style="center; margin-top: 2.5%">
					<button type="submit" class="btn btn-success">
						<span class="glyphicon glyphicon-ok"></span>Guardar Cambios
					</button>
				</div>
			</div>
			</form>		
	</div>
</body>
</html>
