<%@page import="beans.Distrito"%>
<%@page import="beans.Provincia"%>
<%@page import="beans.Departamento"%>
<%@page import="beans.Pais"%>
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
	<h4 class="section-titulo">Gestión de Distritos / Editar Distrito</h4>
	<form class="listaDepartamentosFiltroPais" action="listaDepartamentosFiltro" method="get">
		<div class="row">
			<div class="form-group col-md-4">
				<label for="pais">País</label> <select id="pais"
					class="form-control" name="pais">
					<%List<Pais> lista=(List<Pais>)request.getSession().getAttribute("paises");
						for(Pais pais : lista){%>					
					<option value="<%=pais.getId()%>">
					<%=pais.getNombre() %></option>
					<%} %>
				</select>
			</div>
		</div>
		<input type="hidden" value="editar" name="action">
		<div>
			<button type="submit" class="btn btn-success">
				<span class="glyphicon glyphicon-ok"></span>Siguiente
			</button>
		</div>
	</form>
	<form class="listaProvinciasFiltroDepartamento" action="listaProvinciasFiltro" method="get">
		<div class="row">
			<div class="form-group col-md-4">
				<label for="departamento">Departamento</label> <select id="departamento"
					class="form-control" name="departamento">					
					<%List<Departamento> listaDepas=(List<Departamento>)request.getAttribute("departamentosFiltro");
						for(Departamento depa : listaDepas){%>
					<option value="<%=depa.getId()%>"><%=depa.getNombre() %></option>
					<%} %>					
				</select>
			</div>	
		</div>
		<input type="hidden" value="editar" name="action">
		<div>
			<button type="submit" class="btn btn-success">
				<span class="glyphicon glyphicon-ok"></span>Siguiente
			</button>
		</div>
	</form>
	<form id="putDistrito">
		<%Distrito dist=(Distrito)request.getAttribute("distrito"); %>
		<input type="hidden" name="id" value="<%=dist.getId()%>">
		<div class="row">
		
			<div class="form-group col-md-2">
				<label for="nombre">Nombre</label> <input type="text"
					class="form-control" id="nombre" placeholder="Escribir nombre"
					name="nombre" value="<%=dist.getNombre()%>">
			</div>
			<div class="form-group col-md-4">
				<label for="provincia">Provincia</label> <select id="provincia"
					class="form-control" name="provincia">
					<%List<Provincia> listaProv=(List<Provincia>)request.getAttribute("provinciasFiltro");
						for(Provincia prov : listaProv){%>
					<option value="<%=prov.getId()%>"><%=prov.getNombre() %></option>
					<%} %>
				</select>
			</div>
			<div class="form-group col-md-4">
				<label for="poblacion">Poblacion</label> <input type="number"
					class="form-control" id="poblacion"
					placeholder="Escribir población" name="poblacion" 
					value="<%=dist.getPoblacion()%>">
			</div>
		</div>
		<div>
			<button type="submit" class="btn btn-success">
				<span class="glyphicon glyphicon-ok"></span>Guardar Cambios
			</button>
		</div>
	</form>

</body>
</html>