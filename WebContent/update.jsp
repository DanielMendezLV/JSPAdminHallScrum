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
					<li role="presentation"><span
						class="glyphicon glyphicon-log-out"></span><a href="Logout.do">     Logout</a></li>
				</ul>
			</nav>
		</div>

		<div class="row-fluid">
			<div role="tabpanel">
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane ${pos2 }" id="Usuario">
						<div class="well well-main">
							<p class="name-out">Actualizar Usuario</p>
						</div>
						<div class="col-sm-10 justify col-sm-offset-2">
								<div class="col-md-9">
									<div class="columna">
										<div class="panel-body">
											<form class="form-horizontal" action="Update.do" method="post">
												<input type="hidden" name="go" value="2"> <input
													type="hidden" name="id" value="${user.getIdUsuario() }">
												<div class="form-group" data-bind="with: logUser">
													<label for="inputNick" class="col-sm-2 control-label">Nombre</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="nombre"
															value="${user.getNombre() }" REQUIRED />
													</div>
													<label for="inputNick" class="col-sm-2 control-label">Apellido</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="apellido"
															value="${user.getApellido() }" REQUIRED />
													</div>
													<label for="contenido" class="col-sm-2 control-label">Nick</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="nick"
															value="${user.getNickname() }" REQUIRED />
													</div>
													<label for="inputNick" class="col-sm-2 control-label">Contraseña</label>
													<div class="col-sm-10">
														<input type="password" class="form-control" name="password"
															value="${user.getContrasena() }" REQUIRED />
													</div>
												</div>
												<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span>    Update</button>
											</form>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div role="tabpanel" class="tab-pane ${pos3 }" id="Equipo">
						<div class="well well-sm">
							<p class="name-out">Actualizar Equipo</p>
						</div>
						<div class="col-sm-10 justify col-sm-offset-2">
							<div class="col-md-9">
								<div class="columna">
									<div class="panel-body">
										<form class="form-horizontal" action="Update.do" method="post">
											<input type="hidden" name="go" value="3"> <input
												type="hidden" name="id" value="${equip.getIdequipo() }">
											<div class="form-group" data-bind="with: logUser">
												<label for="inputNick" class="col-sm-2 control-label">Nombre</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" name="nombre"
														value="${equip.getNombre() }" REQUIRED />
												</div>


											</div>
											<button type="submit" class="btn btn-primary"> <span class="glyphicon glyphicon-ok"></span>    Update</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div role="tabpanel" class="tab-pane ${pos4 }" id="Proyecto">
						<div class="well well-sm">
							<p class="name-out">Actualizar Proyecto</p>
						</div>
						<div class="col-sm-10 justify col-sm-offset-2">
							<div class="col-md-9">
								<div class="columna">
									<div class="panel-body">
										<form class="form-horizontal" action="Update.do" method="post">
											<input type="hidden" name="go" value="4"> <input
												type="hidden" name="id" value="${proy.getIdproyecto() }">
											<div class="form-group" data-bind="with: logUser">
												<label for="inputNick" class="col-sm-2 control-label">Nombre</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" name="nombre"
														value="${proy.getNombre() }" REQUIRED />
												</div>
											</div>
											<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span>    Update</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div role="tabpanel" class="tab-pane ${pos5 }" id="Fase">
						<div class="well well-sm">
							<p class="name-out">Actualizar Fase</p>
						</div>
						<div class="col-sm-10 justify col-sm-offset-2">
							<div class="col-md-9">
								<div class="columna">
									<div class="panel-body">
										<form class="form-horizontal" action="Update.do" method="post">
											<input type="hidden" name="go" value="5"> <input
												type="hidden" name="id" value="${fase.getIdfase() }">
											<div class="form-group" data-bind="with: logUser">
												<label for="inputNick" class="col-sm-2 control-label">Nombre</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" name="nombre"
														value="${fase.getNombre() }" REQUIRED />
												</div>
											</div>
											<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span>    Update</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div role="tabpanel" class="tab-pane ${pos6 }" id="Meta">
						<div class="well well-sm">
							<p class="name-out">Actualizar Meta</p>
						</div>
						<div class="col-sm-10 justify col-sm-offset-2">
							<div class="col-md-9">
								<div class="columna">
									<div class="panel-body">
										<form class="form-horizontal" action="Update.do" method="post">
											<input type="hidden" name="go" value="6"> <input
												type="hidden" name="id" value="${meta.getIdmeta() }">
											<div class="form-group" data-bind="with: logUser">
												<label for="inputNick" class="col-sm-2 control-label">Nombre</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" name="descripcion"
														value="${meta.getDescripcion() }" REQUIRED />
												</div>
											</div>
											<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span>    Update</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>


					<div role="tabpanel" class="tab-pane ${pos8 }" id="mensaje">
						<div class="well well-sm">
							<p class="name-out">Actualizar Mensaje</p>
						</div>
						<div class="col-sm-10 justify col-sm-offset-2">
							<div class="col-md-10">
								<div class="columna">
									<div class="panel-body">
										<form class="form-horizontal" action="Update.do" method="post">
											<input type="hidden" name="go" value="8"> <input
												type="hidden" name="id" value="${msg.getIdmensaje() }">
											<div class="form-group" data-bind="with: logUser">
												<label for="inputNick" class="col-sm-2 control-label">Texto</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" name="texto"
														value="${msg.getTexto() }" REQUIRED />
												</div>
											</div>
											<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span>    Update</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
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