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
			<h1 class="text-center">Halley GT�</h1>
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
						class="glyphicon glyphicon-log-out"></span><a href="Logout.do">
							Logout</a></li>
				</ul>
			</nav>
		</div>

		<div class="row-fluid">
			<div class="well well-sm">
				<div class="name-area">
					<h2 class="name">Fases</h2>
				</div>
			</div>
			
			<div class="col-sm-10 justify col-sm-offset-2">
				<c:set var="num" scope="session" value="4" />
				<c:forEach var="fase" items="${listadoFase}" begin="${pagin*num }" end="${((pagin+1)*num)-1 }">
					<div class="col-sm-5 justify ">
						<div class="columna">
							<span>${fase.getIdfase() }</span>
							<h2 class="subtitle">${fase.getNombre()}</h2> del <span>${fase.getFechainicio() }
							</span> al <span> ${ fase.getFechafinalizacion()}</span>
							
							<article class="contenido">
								<small data-toggle="modal" data-target="#detalleEquipo${fase.getIdfase() }"> <a class="autorA" href="#"><span class="glyphicon glyphicon-info-sign"></span> Detalles </a></small>
								<small data-toggle="modal" data-target="#elim${fase.getIdfase() }"><a class="fechaA" href="#"><span class="glyphicon glyphicon-remove"></span> Eliminar</a></small>
								<small><a class="fechaA" href="redUpdate.do?go=5&id=${fase.getIdfase() }"><span class="glyphicon glyphicon-pencil"></span>     Editar</a></small>
							</article>
						</div>
						<div>
							<br>
							<br>
						</div>
					</div>
					<!-- Modal -->
					<div class="modal fade" id="detalleEquipo${fase.getIdfase() }"
						tabindex="-1" role="dialog"
						aria-labelledby="detalleEquipo${fase.getIdfase() }Label">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">${fase.getNombre() }</h4>
								</div>
								<div class="modal-body">
									<h3>Metas para esta fase:</h3>
									<ul>
										<c:forEach var="detFase" items="${fase.getListaMetas()}"
											begin="0" end="4">
											<li><small>${detFase.getDescripcion()}</small> <small>${detFase.isEstado()}</small></li>
										</c:forEach>
									</ul>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<!-- Modal -->
					<div class="modal fade" id="elim${fase.getIdfase() }" tabindex="-1"
						role="dialog" aria-labelledby="elim${fase.getIdfase() }Label">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">Desea eliminar :
										${fase.getNombre() }</h4>
								</div>
								<div class="modal-body">
									<a href="Eliminar.do?go=5&id=${fase.getIdfase() }"><button
											type="button" class="btn btn-xs btn-info">Si</button></a> <a
										href="#"><button type="button" class="btn btn-xs btn-info"
											data-dismiss="modal">No</button></a>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<c:if test="${pagin != 0 && pagin!=null}">
					<a href="Redirect.do?go=5&pagin=${pagin-1 }"><button
							type="button" class="btn btn-primary"><span class="glyphicon glyphicon-arrow-left"></span></button></a>
				</c:if>
				<c:if test="${(((pagin+1)*num)) < listadoFase.size() }">
					<a href="Redirect.do?go=5&pagin=${pagin+1 }"><button type="button" class="btn btn-primary" data-dismiss="modal">
						<span class="glyphicon glyphicon-arrow-right"></span></button>
					</a>
				</c:if>
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