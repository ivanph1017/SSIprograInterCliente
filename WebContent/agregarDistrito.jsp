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
	<h4 class="section-titulo">Gestión de Distritos / Agregar Distrito</h4>

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
		<input type="hidden" class="accion" value="registrarDistrito" name="action">
		<div>
			<button type="submit" class="btn btn-success">
				<span class="glyphicon glyphicon-ok"></span>Siguiente
			</button>
		</div>
	</form>
	<div class="row">
		<div class="selector col-md-12"></div>
	</div>
	<div class="row">
		<div class="formFinal col-md-12"></div>
	</div>
		
</body>
</html>