<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="requestsresponses.AlumnoResponse"%>
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
		<h4 class="section-titulo">Gestión de Asignaturas / Asignar
			Alumnos a Sección</h4>
		<form>
			<fieldset disabled="disabled">
				<%
					SeccionResponse seccion = (SeccionResponse) request.getAttribute("seccionPertenece");
				%>
				<div class="row">
					<div class="form-group col-sm-2">
						<label for="codigo">Código de Sección</label> <input type="number"
							class="form-control" id="codigo" value="<%=seccion.getCodigo()%>"
							name="codigo">
					</div>
					<div class="form-group col-sm-4">
						<label for="curso">Curso</label> <input type="text"
							class="form-control" id="curso" value="<%=seccion.getCurso()%>"
							name="curso">
					</div>
					<div class="form-group col-sm-4">
						<label for="profesor">Profesor</label> <input type="text"
							class="form-control" id="profesor"
							value="<%=seccion.getProfesor()%>" name="profesor">
					</div>
				</div>
			</fieldset>
		</form>
		<form id="postAlumnoSeccion" action="alumnoSeccion" method="post">
			<input type="hidden" class="form-control" id="idSeccion"
				value="<%=seccion.getId()%>" name="idSeccion">
			<div class="table-responsive">
				<table class="table table-striped ">
					<thead>
						<tr>
							<th>Codigo</th>
							<th>Apellido Paterno</th>
							<th>Apellido Materno</th>
							<th>Nombre</th>
							<th>Pertenece</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<AlumnoResponse> listaAlumno = (List<AlumnoResponse>) request.getSession().getAttribute("alumnos");
							Map<Integer, Integer> mapita = (Map<Integer, Integer>) request.getAttribute("relacionAlumnos");
							for (AlumnoResponse alumno : listaAlumno) {
						%>
						<tr>
							<td><%=alumno.getCodigo()%></td>
							<td><%=alumno.getApellido_paterno()%></td>
							<td><%=alumno.getApellido_materno()%></td>
							<td><%=alumno.getNombres()%></td>
							<td><div class="checkbox">
								<%
										if (mapita.isEmpty()) {
									%>
									<label> <input id="<%=alumno.getId() %>caja" name="<%=alumno.getId() %>" type="checkbox" class="check" value="true"
										aria-label="..." class="checking">
										<input name="<%=alumno.getId() %>"  type="hidden" id="<%=alumno.getId() %>hidden"
									aria-label="..." value="false">
									</label>
									<%
										}else {

											if (mapita.get(alumno.getId()) == 1) {
								%>
								<label> <input name="<%=alumno.getId() %>"  id="<%=alumno.getId() %>caja"  type="checkbox"
									aria-label="..." value="true" checked="checked" class="checking">
									<input name="<%=alumno.getId() %>"  type="hidden" id="<%=alumno.getId() %>hidden"
									aria-label="..." value="false">
								</label>
								<%
									} else if (mapita.get(alumno.getId()) == 0) {
								%>
								<label> <input name="<%=alumno.getId() %>" id="<%=alumno.getId() %>caja" type="checkbox" value="true"
									aria-label="..." class="checking">
									<input name="<%=alumno.getId() %>"  type="hidden" id="<%=alumno.getId() %>hidden"
									aria-label="..." value="false">
								</label>
								<script>
									$('#<%=alumno.getId()%>caja').off('click').on('click',function () {
							         if (!($(this).checked)) {
							        	 $('#<%=alumno.getId()%>hidden').prop('checked', true);
							         }
							      });									
								</script>

								<%
									}
										}
								%>	
								</div></td>
						</tr>						
						<%
							}
						%>						
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
