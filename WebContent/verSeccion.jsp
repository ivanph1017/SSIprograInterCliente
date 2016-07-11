<%@page import="requestsresponses.SeccionResponse"%>
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
		<h4 class="section-titulo">Gestión de Asignaturas / Ver Sección</h4>
		<form>
		<%SeccionResponse seccion = (SeccionResponse) request.getAttribute("seccion"); %>
			<fieldset disabled="disabled">
				<div class="row">
					<div class="form-group col-md-2">
						<label for="codigo">Código</label> <input type="number"
							class="form-control" id="codigo" value="<%=seccion.getCodigo() %>" name="codigo">
					</div>
					<div class="form-group col-md-4">
						<label for="curso">Curso</label> <select id="curso"
							class="form-control" name="curso">
							<option selected="selected" value="<%=seccion.getId_curso() %>"><%=seccion.getCurso() %></option>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label for="profesor">Profesor</label> <select id="profesor"
							class="form-control" name="profesor">
							<option selected="selected" value=<%=seccion.getId_profesor() %>><%=seccion.getProfesor() %></option>
						</select>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>
