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

	<h4 class="section-titulo">Gestión de Distritos / Ver Distrito</h4>
	<form>
		<fieldset disabled="disabled">
			<div class="row">
				<div class="form-group col-md-2">
					<label for="nombre">Nombre</label> <input type="text"
						class="form-control" id="nombre" placeholder="Escribir nombre"
						name="nombre">
				</div>
				<div class="form-group col-md-4">
					<label for="provincia">Provincia</label> <select id="provincia"
						class="form-control" name="provincia">
						<option value=""></option>
					</select>
				</div>
				<div class="form-group col-md-4">
					<label for="poblacion">Poblacion</label> <input type="number"
						class="form-control" id="poblacion"
						placeholder="Escribir población" name="poblacion">
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-ok"></span>Guardar Cambios
				</button>
			</div>
		</fieldset>
	</form>

</body>
</html>
