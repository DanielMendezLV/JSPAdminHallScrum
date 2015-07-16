<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">    
    <link href="css/price-range.css" rel="stylesheet">    
    <link href="css/responsive.css" rel="stylesheet">
    <link href="Site.css" rel="stylesheet">
    
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



<div class="row">
 	<a href="Logout.do"><button type="button" class="btn btn-xs btn-info">Logout</button></a>
    <div class="col-md-6">
        <div class="panel panel-default"> 
            <div role="tabpanel">
                <ul class="nav nav-tabs" role="tablist">                
                    <li role="presentation"><a href="Redirect.do?go=1">Rol</a></li>
                    <li role="presentation"><a href="Redirect.do?go=2">Usuario</a></li>
                    <li role="presentation"><a href="Redirect.do?go=3">Equipo</a></li>
                    <li role="presentation"><a href="Redirect.do?go=4">Proyecto</a></li>
                    <li role="presentation"><a href="Redirect.do?go=5">Fase</a></li>
                    <li role="presentation"><a href="Redirect.do?go=6">Meta</a></li>
                    <li role="presentation" class="active"><a href="Redirect.do?go=7">Reunion</a></li>
                    <li role="presentation"><a href="Redirect.do?go=8">Mensaje</a></li></ul>
                <div class="tab-content">
                		<div role="tabpanel" class="tab-pane active" id="Reunion">
                       	<div class="panel-heading">
                            <h2 class="panel-title">Reunion</h2>
                        </div>
                        <div class="panel-body">	
                        						
							<div class="col-md-10">
					            <div class="panel panel-default">
					                <div class="panel-heading">
					                    <h2 class="panel-title">Reunion</h2>
					                </div>
					                <div class="panel-body">
					                    <ul class="list-unstyled" >
					                    	    	<c:forEach var="reunion" items="${listaReunion}">				
					                        <li>
					                           
					                           
					                            <strong><span>${reunion.getFecha()}</span></strong>: <span >${reunion.getEquipo()}</span>
					                            <span>${reunion.getHora() }</span>
					                            <small><a style="color:blue"  href="#" >Eliminar</a></small>
					                            <small><a style="color:blue"  href="#" >Editar</a></small>
					                        </li>
					                        	    	</c:forEach>
                 
					                    </ul>
					                </div>
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