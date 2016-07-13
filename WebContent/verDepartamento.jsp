<%@page import="beans.Departamento"%>
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
	<h4 class="section-titulo">Gestión de Departamentos / Ver
		Departamento</h4>
	<%Departamento dpto=(Departamento)request.getAttribute("departamento"); %>
	<form action="#" method="post">
		<fieldset disabled="disabled">
			<div class="row">
				<div class="form-group col-md-5">
					<label for="nombre">Nombre</label> <input type="text"
						class="form-control" id="nombre"
						name="nombre" value="<%=dpto.getNombre() %>">
				</div>
				<div class="form-group col-md-3">
					<label for="pais">Pais</label> <select id="pais"
						class="form-control" name="pais">
						<option value="<%=dpto.getPais().getId()%>"><%=dpto.getPais().getNombre() %></option>
					</select>
				</div>
			</div>			
		</fieldset>
	</form>
</body>
</html>