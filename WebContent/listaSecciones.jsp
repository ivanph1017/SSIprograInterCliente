<%@page import="requestsresponses.SeccionResponse"%>
<%@page import="java.util.List"%>
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
		<h4 class="section-titulo">Gestión de Asignaturas / Ver Lista de
			Secciones</h4>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Nombre Curso</th>
						<th>Carrera</th>
						<th>Alumnos Matriculados</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
				<%List<SeccionResponse> lista = (List<SeccionResponse>) request.getSession().getAttribute("secciones");
				for(SeccionResponse seccion : lista){
				%>
					<tr>
						<td><%= seccion.getCodigo() %></td>
						<td><%= seccion.getCurso() %></td>
						<td><%= seccion.getEscuela() %></td>
						<td><%= seccion.getCantidadAlumnos() %></td>
						<td><a class="editarSeccion" href="#" data-index-number="<%=seccion.getId()%>" data-action="editar"><span
								class="glyphicon glyphicon-pencil"></span></a> <a class="verSeccion"
							href="#" data-index-number="<%=seccion.getId()%>" data-action="ver"><span class="glyphicon glyphicon-zoom-in"></span></a> <a
							class="asignarNotasAlumnoSeccion" href="#" data-index-number="<%=seccion.getId()%>"><span
								class="glyphicon glyphicon-list"></span></a> <a
							class="asignarAlumnosASeccion" href="#" data-index-number="<%=seccion.getId()%>"><span
								class="glyphicon glyphicon-user"></span></a> <a class="eliminarSeccion"
							href="#" data-index-number="<%=seccion.getId()%>"><span class="glyphicon glyphicon-remove"></span></a></td>
					</tr>
				<%} %>
				</tbody>
			</table>
		</div>		
		<div>
			<a href="#" role="button" class="btn btn-success agregarSeccion"><span
			class="glyphicon glyphicon-plus"></span>Agregar Registro</a>		
		</div>
		
	</div>
</body>
</html>