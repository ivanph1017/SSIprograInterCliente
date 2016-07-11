<%@page import="requestsresponses.CursoResponse"%>
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
		<h4 class="section-titulo">Gestión de Asignaturas / Ver Curso</h4>
		<form action="#" method="post">
		<%CursoResponse curso = (CursoResponse) request.getAttribute("curso"); %>
			<fieldset disabled="disabled">
				<div class="row">
					<div class="form-group col-md-5">
						<label for="nombre">Nombre</label> <input type="text"
							class="form-control" id="nombre" value="<%=curso.getNombre()%>" name="nombre">
					</div>
					<div class="form-group col-md-2">
						<label for="codigo">Código</label> <input type="number"
							class="form-control" id="codigo" value="<%=curso.getCodigo() %>" name="codigo">
					</div>
					<div class="form-group col-md-3">
						<label for="carrera">Carrera</label> <select id="carrera"
							class="form-control" name="carrera">
							<option selected="selected" value="<%=curso.getId_escuela() %>"><%=curso.getEscuela() %></option>
						</select>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>