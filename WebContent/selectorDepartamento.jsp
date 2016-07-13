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
<%List<Departamento> listaDepas=(List<Departamento>)request.getAttribute("departamentosFiltro");
	Integer idDistrito=(Integer)request.getAttribute("idDistrito");
	%>
	<form class="listaProvinciasFiltroDepartamento" action="listaProvinciasFiltro" method="get">
		<div class="row">
			<div class="form-group col-md-4">
				<label for="departamento">Departamento</label> <select id="departamento"
					class="form-control" name="departamento">					
					<%for(Departamento depa : listaDepas){%>
					<option value="<%=depa.getId()%>"><%=depa.getNombre() %></option>
					<%} %>					
				</select>
			</div>	
		</div>
		
		<%if(idDistrito!=null){
			%>
			<input type="hidden" class="accion2" value="editarDistrito" name="action">
			<input type="hidden" value="<%=idDistrito%>" name="idDistrito">
		<%}else{
			%>
			<input type="hidden" class="accion2" value="registrarDistrito" name="action">
		<%} %>
		<div>
			<button type="submit" class="btn btn-success">
				<span class="glyphicon glyphicon-ok"></span>Siguiente
			</button>
		</div>
	</form>	
</body>
</html>