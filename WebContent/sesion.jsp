<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery-2.2.3.js"></script>
<link rel="stylesheet" href="bootstrap-3.3.6-dist/css/bootstrap.min.css" />
<script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/custom2.css" />
<script src="js/custom.js"></script>
<title>Panel de control</title>
</head>
<body id="inicio">

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="#inicio"><img src="img/logo.png"
					style="padding: 0%; height: 7%; padding-left: 2%" /></a>
			</div>			
		</div>
	</nav>
	<div id="areaCentro" class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<div id="asideBase">
				<ul class="leftbar">
					<li><span class="glyphicon glyphicon-globe leftheading"></span>
						<h4 class="leftheading">Gestión de Paises</h4>
						<ul class="leftbar subheading">
							<li><a class="agregarPais" href="#"><h5>>>
										Agregar Pais</h5></a></li>
							<li><a id="listaPaises" href="#"><h5>>> Ver
										Lista de Paises</h5></a></li>
						</ul></li>
					<li><span class="glyphicon glyphicon-globe leftheading"></span>
						<h4 class="leftheading">Gestión de Departamentos</h4>
						<ul class="leftbar subheading">
							<li><a class="agregarDepartamento" href="#"><h5>>>
										Agregar Departamento</h5></a></li>
							<li><a id="listaDepartamentos" href="#"><h5>>> Ver Lista
										de Departamentos</h5></a></li>
						</ul></li>
					<li><span class="glyphicon glyphicon-globe leftheading"></span>
						<h4 class="leftheading">Gestión de Provincias</h4>
						<ul class="leftbar subheading">
							<li><a class="agregarProvincia" href="#"><h5>>>
										Agregar Provincia</h5></a></li>
							<li><a id="listaProvincias" href="#"><h5>>> Ver Lista
										de Provincias</h5></a></li>
						</ul></li>	
					<li><span class="glyphicon glyphicon-globe leftheading"></span>
						<h4 class="leftheading">Gestión de Distritos</h4>
						<ul class="leftbar subheading">
							<li><a class="agregarDistrito" href="#"><h5>>> Agregar
										Distrito</h5></a></li>
							<li><a id="listaDistritos" href="#"><h5>>> Ver Lista
										de Distritos</h5></a></li>							
						</ul></li>
					<li><span class="glyphicon glyphicon-open leftheading"></span>
						<h4 class="leftheading">Gestión de cargas</h4>
						<ul class="leftbar subheading">
							<li><a id="cargaMongo" href="#"><h5>>> Carga de documentos
								en Mongo</h5></a></li>
							<li><a id="mysqlPais" href="#"><h5>>> Carga masiva de Paises en
							MySQL</h5></a></li>
							<li><a id="mysqlDpto" href="#"><h5>>> Carga masiva de Departamentos en
							MySQL</h5></a></li>	
							<li><a id="mysqlProv" href="#"><h5>>> Carga masiva de Provincias en
							MySQL</h5></a></li>	
							<li><a id="mysqlDist" href="#"><h5>>> Carga masiva de Distritos en
							MySQL</h5></a></li>								
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9">
			<div id="seccionBase"></div>
		</div>
	</div>		
	</div>
	<footer class="container-fluid">	
		<ul>
			<li>Sergio Espinoza</li>
			<li>Sandra Fraile</li>
			<li>Iván Palomares</li>			
		</ul>	
	</footer>
	
	
</body>
</html>