<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">    
    <link href="css/price-range.css" rel="stylesheet">    
    <link href="css/responsive.css" rel="stylesheet">
    <link href="css/Site.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<div class="content">
		<div class="row">
			<div class="col-md-4">
				<span id="title">¡Bienvenido!</span>
				<div class="panel panel-default" id="login-panel">
					<div role="tabpanel" class="tab-pane active" id="Logear">
						<div class="panel-body">
							<form class="form-horizontal" action="Login.do" method="post">
								<div class="form-group" data-bind="with: logUser">
									<div class="col-sm-12">
										<br>
										<input type="text" class="form-control" name="txtNick"
											REQUIRED placeholder="Usuario"/>
									</div>
									<div class="col-sm-12">
										<br>
										<input type="password" class="form-control" name="txtPass"
											REQUIRED placeholder="Contraseña"/>
									</div>
								</div>
								<button type="submit" class="btn btn-primary">
									<span class="glyphicon glyphicon-send"></span> Login
								</button>
							</form>
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