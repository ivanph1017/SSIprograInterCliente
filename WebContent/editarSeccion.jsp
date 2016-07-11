<%@page import="requestsresponses.ProfesorResponse"%>
<%@page import="requestsresponses.CursoResponse"%>
<%@page import="java.util.List"%>
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
		<h4 class="section-titulo">Gestión de Asignaturas / Editar
			Sección</h4>
		<form id="putSeccion">
		<%SeccionResponse seccion=(SeccionResponse) request.getAttribute("seccion"); %>
			<div class="row">
				<div class=" col-md-2" style="margin-top: 2%">
					<label for="codigo">Código</label> <input type="number"
						class="form-control" id="codigo" value="<%=seccion.getCodigo()%>" name="codigo">
				</div>
				<div class=" col-md-4" style="margin-top: 2%">
					<label for="curso">Curso</label> <select id="curso"
						class="form-control" name="curso">
						<%List<CursoResponse> cursos = (List<CursoResponse>) request.getSession().getAttribute("cursos"); 
						for(CursoResponse curso : cursos){				
						%>
						<option value="<%=curso.getId()%>"><%=curso.getNombre() %></option>
						<%}%>
					</select>
				</div>
				<div class=" col-md-4" style="margin-top: 2%">
					<label for="profesor">Profesor</label> <select id="profesor"
						class="form-control" name="profesor">
						<%List<ProfesorResponse> profes = (List<ProfesorResponse>) request.getSession().getAttribute("profesores"); 
						for(ProfesorResponse profe : profes){				
						%>
						<option value="<%=profe.getId()%>"><%=profe.getNombres() + " "+profe.getApellido_paterno()+ " " + profe.getApellido_materno() %></option>
						<%}%>
					</select>
				</div>
			</div>
			<input type="hidden"
						class="form-control" id="idEditarProfesor"
						name="id"
						value="<%=seccion.getId()%>">
			
			<div class="row">
				<div class="col-md-3" style="margin-top: 2.5%">
					<button type="submit" class="btn btn-success">
						<span class="glyphicon glyphicon-ok"></span>Guardar Cambios
					</button>
				</div>
				
			</div>
		</form>
	</div>
</body>
</html>