<%@page import="java.util.List"%>
<%@page import="requestsresponses.AlumnoSeccion"%>
<%@page import="java.util.Map"%>
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
		<h4 class="section-titulo">Gestión de Asignaturas / Asignar Notas
			a Alumno de Sección</h4>
		<form action="#" method="post">
		<%SeccionResponse seccion = (SeccionResponse)request.getAttribute("seccionNotas");
			
		%>
			<fieldset disabled="disabled">
				<div class="row">
					<div class="form-group col-sm-2">
						<label for="codigo">Código de Sección</label> <input type="number"
							class="form-control" id="codigo" value="<%=seccion.getCodigo()%>" name="codigo">
					</div>
					<div class="form-group col-sm-4">
						<label for="curso">Curso</label> <input type="text"
							class="form-control" id="curso" value="<%=seccion.getCurso() %>"
							name="curso">
					</div>
					<div class="form-group col-sm-4">
						<label for="profesor">Profesor</label> <input type="text"
							class="form-control" id="profesor" value="<%=seccion.getProfesor() %>"
							name="profesor">
					</div>
				</div>
			</fieldset>
			</form>
			<form id="postNotasSeccion" action="notaSeccion" method="post">
			<div class="table-responsive">
				<table class="table table-striped ">
					<thead>					
						<tr>
							<th>Codigo</th>
							<th>Apellido Paterno</th>
							<th>Apellido Materno</th>
							<th>Nombre</th>
							<th>Nota</th>
						</tr>
					</thead>
					<tbody>
					<%Map<Integer,Integer> mapita=(Map<Integer, Integer>) request.getAttribute("relacionAlumnosNotas"); 
					List<AlumnoSeccion> as=(List<AlumnoSeccion>)request.getAttribute("alumnosSeccion"); 
					for(AlumnoSeccion alumno : as){						
					
					%>	
						<tr>
							<td><%=alumno.getCodigo() %></td>
							<td><%=alumno.getApellido_paterno() %></td>
							<td><%=alumno.getApellido_materno() %></td>
							<td><%=alumno.getNombre() %></td>							
							<%if(mapita.isEmpty()){
								%><td><input type="number" name="<%=alumno.getId() %>" value=""							
								class="form-control" required="required" /></td>
							<%}else{ %>
								<td><input type="number" name="<%=alumno.getId() %>" value="<%=mapita.get(alumno.getId()) %>"							
								class="form-control" required="required"/></td>
							<%}%>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>

			<div style="margin-top: 2.5%">
				<button type="submit" class="btn btn-success btn-agregar">
					<span class="glyphicon glyphicon-ok"></span>Guardar Cambios
				</button>
			</div>
		</form>
	</div>

</body>
</html>
