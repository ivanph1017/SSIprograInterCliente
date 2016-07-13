<%@page import="beans.Departamento"%>
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
		<h4 class="section-titulo">Gestión de Departamentos / Ver Lista de
			Departamentos</h4>		
			<div class="table-responsive">
				<table class="table table-striped ">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Pais</th>							
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
					<%List<Departamento> lista=(List<Departamento>) request.getAttribute("departamentos"); 
					for(Departamento dpto : lista){
					%>		
						<tr>
							<td><%=dpto.getNombre() %></td>
							<td><%=dpto.getPais().getNombre() %></td>							
							<td><a class="editarDepartamento" data-index-number="<%=dpto.getId() %>" data-action="editar" href="#"><span
									class="glyphicon glyphicon-pencil"></span></a> <a class="verDepartamento" data-action="ver"
								href="#" data-index-number="<%=dpto.getId() %>"><span class="glyphicon glyphicon-zoom-in"></span></a> <a
								class="eliminarDepartamento" href="#" data-index-number="<%=dpto.getId() %>"><span
									class="glyphicon glyphicon-remove"></span></a></td>
						</tr>
						<%} %>					
					</tbody>
				</table>
			</div>		
		<div>
			<a href="#" role="button"
				class="btn btn-success btn-agregar agregarDepartamento"><span
				class="glyphicon glyphicon-plus"></span>Agregar Registro</a>
		</div>
	</div>
</body>
</html>