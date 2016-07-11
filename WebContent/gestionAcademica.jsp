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
<body>
	<div id="asideBase">
				<ul class="leftbar">
					<li><span class="glyphicon glyphicon-briefcase leftheading"></span>
						<h4 class="leftheading">Gestión de Profesores</h4>
						<ul class="leftbar subheading">
							<li><a class="agregarProfesor" href="#"><h5>>>
										Agregar Profesor</h5></a></li>
							<li><a id="listaProfesores" href="#"><h5>>> Ver
										Lista de Profesores</h5></a></li>
						</ul></li>
					<li><span class="glyphicon glyphicon-education leftheading"></span>
						<h4 class="leftheading">Gestión de Alumnos</h4>
						<ul class="leftbar subheading">
							<li><a class="agregarAlumno" href="#"><h5>>>
										Agregar Alumno</h5></a></li>
							<li><a id="listaAlumnos" href="#"><h5>>> Ver Lista
										de Alumnos</h5></a></li>
						</ul></li>
					<li><span class="glyphicon glyphicon-book leftheading"></span>
						<h4 class="leftheading">Gestión de Asignaturas</h4>
						<ul class="leftbar subheading">
							<li><a class="agregarCurso" href="#"><h5>>> Agregar
										Curso</h5></a></li>
							<li><a id="listaCursos" href="#"><h5>>> Ver Lista
										de Cursos</h5></a></li>
							<li><a class="agregarSeccion" href="#"><h5>>>
										Agregar sección</h5></a></li>
							<li><a id="listaSecciones" href="#"><h5>>> Ver
										Lista de Secciones</h5></a></li>
						</ul></li>
				</ul>
			</div>
</body>
</html>