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

	<h4 class="section-titulo">Formulario para realizar carga masiva a MySQL</h4>
	<label>Si las tablas están vacías, es necesario que se inserte la data en el
	siguiente orden: Pais - Departamento - Provincia - Distrito</label>
	<form id="postMySQLDistritos" action="mySQLDistritos" method="post" enctype="multipart/form-data">	
		<div class="row">
			<div class="form-group col-md-5" style="">
				<label for="txt">Archivo plano de distritos</label> <input type="file" class="form-control"
					id="txt" accept="text/plain" name="txt"
					required="required">
			</div>
		</div>		
		<button type="submit" class="btn btn-success">
			<span class="glyphicon glyphicon-plus"></span> <span>Subir archivo</span>
		</button>
	</form>	
</body>
</html>