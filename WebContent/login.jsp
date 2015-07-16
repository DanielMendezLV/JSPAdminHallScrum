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
    <div class="col-md-4">
        <div class="panel panel-default">
            
            <div role="tabpanel">
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#Logear" aria-controls="lista" role="tab" data-toggle="tab">Logear</a></li>
                </ul>
                <div class="tab-content">

                    <div role="tabpanel" class="tab-pane active" id="Logear">
                        <div class="panel-heading">
                            <h2 class="panel-title">Login</h2>
                        </div>

                        <div class="panel-body">
                            <form class="form-horizontal"action="Login.do" method="post" >
                                <div class="form-group" data-bind="with: logUser">
                                    <label for="inputNick" class="col-sm-2 control-label">Nick</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="txtNick" REQUIRED/>
                                    </div>
                                    <label for="inputPass" class="col-sm-2 control-label">Pass</label>
                                    <div class="col-sm-10">
                                        <input type="password" class="form-control" name="txtPass" REQUIRED />
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-default">Login</button>
                            </form>
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