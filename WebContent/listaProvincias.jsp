<%@page import="beans.Provincia"%>
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
		<h4 class="section-titulo">Gestión de Provincias / Ver Lista de
			Provincias</h4>
		<div class="table-responsive">
			<table class="table table-striped ">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Departamento</th>
						<th>País</th>						
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
				<%List<Provincia> lista=(List<Provincia>) request.getAttribute("provincias");
				for(Provincia prov : lista){%>				
					<tr>
						<td><%=prov.getNombre() %></td>
						<td><%=prov.getDepartamento().getNombre() %></td>
						<td><%=prov.getDepartamento().getPais().getNombre() %></td>						
						<td><a class="editarProvincia" href="#" data-index-number="<%=prov.getId() %>" data-action="editar"><span
								class="glyphicon glyphicon-pencil"></span></a> <a class="verProvincia" data-action="ver"
							href="#" data-index-number="<%=prov.getId() %>"><span class="glyphicon glyphicon-zoom-in"></span></a> <a
							class="eliminarProvincia" href="#" data-index-number="<%=prov.getId() %>"><span
								class="glyphicon glyphicon-remove"></span></a></td>
					</tr>	
				<%} %>			
				</tbody>
			</table>
		</div>
		<div>
			<a href="#" role="button"
				class="btn btn-success btn-agregar agregarProvincia"><span
				class="glyphicon glyphicon-plus"></span>Agregar Registro</a>
		</div>
	</div>
</body>
</html>

