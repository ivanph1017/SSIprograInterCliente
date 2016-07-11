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
		<h4 class="section-titulo">Gestión de Alumnos / Ver Alumno</h4>
		<form>
		<%AlumnoResponse alumno = (AlumnoResponse) request.getAttribute("alumno"); %>
			<fieldset disabled="disabled">
				<div class="row">
					<div class="form-group col-md-2">
						<label for="nombre">Nombre</label> <input type="text"
							class="form-control" id="nombre" value="<%=alumno.getNombres() %>" name="nombre">
					</div>
					<div class="form-group col-md-4">
						<label for="apellidopaterno">Apellido Paterno</label> <input
							type="text" class="form-control" id="apellidopaterno"
							value="<%=alumno.getApellido_paterno() %>" name="apellidop">
					</div>
					<div class="form-group col-md-4">
						<label for="apellidomaterno">Apellido Materno</label> <input
							type="text" class="form-control" id="apellidomaterno"
							value="<%=alumno.getApellido_materno() %>" name="apellidom">
					</div>
					<div class="form-group col-md-2">
						<label for="dni">DNI</label> <input type="text"
							class="form-control" id="dni" value="<%=alumno.getDni() %>" name="dni">
					</div>
					<div class="form-group col-md-2">
						<label for="codigo">Código</label> <input type="number"
							class="form-control" id="codigo" value="<%=alumno.getCodigo() %>" name="codigo">
					</div>
					<div class="form-group col-md-4">
						<label for="colegio">Colegio</label> <select id="colegio"
							class="form-control" name="colegio">
							<option select="selected" value="<%= alumno.getId_colegio()%>"><%=alumno.getColegio() %></option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<label>Foto</label>
						<div>
							<img src="<%=alumno.getFoto_url() %>" />
						</div>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>