<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Login</title>
	
	<link href="css/animate.css" rel="stylesheet">
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/style-base.css" rel="stylesheet">
	
	<!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
	    <![endif]-->
	<link rel="shortcut icon" href="images/ico/favicon.ico">
	<link rel="apple-touch-icon-precomposed" sizes="144x144"
		href="images/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114"
		href="images/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72"
		href="images/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed"
		href="images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->

<body>
	<div class="container-fluid">
		<div id="cabecera">
			<h1 class="text-center">Halley GT§</h1>
			<nav id="nav-principal">
				<ul>
					<li role="presentation" class="active"><a
						href="Redirect.do?go=1">Rol</a></li>
					<li role="presentation"><a href="Redirect.do?go=2">Usuario</a></li>
					<li role="presentation"><a href="Redirect.do?go=3">Equipo</a></li>
					<li role="presentation"><a href="Redirect.do?go=4">Proyecto</a></li>
					<li role="presentation"><a href="Redirect.do?go=5">Fase</a></li>
					<li role="presentation"><a href="Redirect.do?go=6">Meta</a></li>
					<li role="presentation"><a href="Redirect.do?go=7">Reunion</a></li>
					<li role="presentation"><a href="Redirect.do?go=8">Mensaje</a></li>
					<li role="presentation"><span class="glyphicon glyphicon-log-out"></span><a href="Logout.do">     Logout</a></li>
				</ul>
			</nav>
		</div>
		<div class="row-fluid">
			<div class="col-sm-10 justify col-sm-offset-2">
				<c:set var="num" scope="session" value="4"/>
				<c:forEach var="roles" items="${listadoRol}">
					<div class="col-sm-5 justify ">
						<div class="columna">
							<div>${roles.getIdRol()}</div>
							<h2 class="subtitle">ROL: ${roles.getNombre()}</h2>
							<article class="contenido">
								<p class="autorA" data-toggle="modal"
									data-target="#updateRol${roles.getIdRol() }"><span class="glyphicon glyphicon-pencil"></span>    EDITAR</p>
									<a class="fechaA" href="Eliminar.do?go=1&id=${roles.getIdRol() }"><span class="glyphicon glyphicon-remove"></span>Eliminar</a>
							</article>

							
						</div>
						<div>
							<hr />
						</div>
					</div>
					<!-- Modal -->
					<div class="modal fade" id="updateRol${roles.getIdRol()}"
						tabindex="-1" role="dialog"
						aria-labelledby="updateRol${roles.getIdRol()}Label">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h3>Editar Rol</h3>
								</div>
								<div class="modal-body">
									<form class="form-horizontal" action="Update.do" method="post">
										<div class="form-group">
											<input type="hidden" name="go" value="1"> <input
												type="hidden" name="id" value="${roles.getIdRol() }">
											<label for="inputPass" class="col-sm-2 control-label">Nombre</label>
											<div class="col-sm-10">

												<input type="text" class="form-control" name="nombre"
													value="${roles.getNombre() }" REQUIRED />
											</div>
										</div>
										<button type="submit" class="btn btn-default">Editar</button>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cerrar</button>
								</div>
							</div>
						</div>
					</div>
					<!-- end modal -->
				</c:forEach>
			</div>
		</div>
	</div>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
</body>
</html>