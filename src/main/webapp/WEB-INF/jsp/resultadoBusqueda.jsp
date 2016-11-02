<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
	<head>
	  <meta charset="utf-8" />
	  <link rel="apple-touch-icon" sizes="76x76" href="img/isologo.png">
	  <link rel="icon" type="image/png" href="img/favicon.png">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	  <title>SoundMate - Resultados</title>
	
	  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
	
	  <!-- Fonts and icons -->
		  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
		  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
	
	  <!-- CSS Files -->
		  <link href="css/bootstrap.min.css" rel="stylesheet" />
		  <link href="css/material-kit.css" rel="stylesheet"/>
	
	</head>
	
	<body class="signup-page">
		<%@ include file="../includes/menu.jsp" %>
	  	<div class="wrapper">
	    	<div class="header header-filter" style="background-image: url('img/bg-concert.jpg'); background-size: cover; background-position: top center;">
		      <div class="container">
		        <div class="row">
		          <div class="col-md-8 col-md-offset-2 col-sm-6 col-sm-offset-3">
		            <div class="card card-signup">
		            
						<div class="content" style="padding-left: 40px;padding-right: 40px;">
						
							<div class="text-center">
			                	<h2>Resultados de tu Búsqueda</h2>
			                	<h4>¡Añade SoundMates a tu banda!</h4>
			                 </div>
			                 
			                 <br/><br/>
			                 
			                 <table class="table">
							    <thead>
							        <tr>
							            <th>SoundMate</th>
							            <th>Instrumento</th>
							            <th>Ubicación</th>
							        </tr>
							    </thead>
							    <tbody>
							        <tr>
							            <td>Martín</td>
							            <td>GUITARRA</td>
							            <td>La Matanza, Buenos Aires Province</td>
							            <td class="td-actions text-right">
							                <a href="perfil">
							                	<button type="button" rel="tooltip" title="Ver Perfil" class="btn btn-info btn-simple btn-xs">
							                    	<i class="fa fa-user"></i>
							                	</button>
							                </a>
							                <button type="button" rel="tooltip" title="Añadir a Banda" class="btn btn-primary btn-simple btn-xs">
						                    	<i class="fa fa-check-square"></i>
						                	</button>
							            </td>
							        </tr>
							        <tr>
							            <td>Rodrigo</td>
							            <td>GUITARRA</td>
							            <td>La Matanza, Buenos Aires Province</td>
							            <td class="td-actions text-right">
							                <a href="perfil">
							                	<button type="button" rel="tooltip" title="Ver Perfil" class="btn btn-info btn-simple btn-xs">
							                    	<i class="fa fa-user"></i>
							                	</button>
							                </a>
							                <button type="button" rel="tooltip" title="Añadir a Banda" class="btn btn-primary btn-simple btn-xs">
							                    <i class="fa fa-check-square"></i>
							                </button>
							            </td>
							        </tr>
							        <tr>
							            <td>Claudio</td>
							            <td>GUITARRA</td>
							            <td>La Matanza, Buenos Aires Province</td>
							            <td class="td-actions text-right">
							                <a href="perfil">
							                	<button type="button" rel="tooltip" title="Ver Perfil" class="btn btn-info btn-simple btn-xs">
							                    	<i class="fa fa-user"></i>
							                	</button>
							                </a>
							                <button type="button" rel="tooltip" title="Añadir a Banda" class="btn btn-primary btn-simple btn-xs">
							                    <i class="fa fa-check-square"></i>
							                </button>
							            </td>
							        </tr>
							    </tbody>
							</table>
									                 		                  
		                </div>
		              
		            </div>
		          </div>
		        </div>
		      </div>
		      <%@ include file="../includes/pie.jsp" %>
	    	</div>
	  	</div>
	</body>

	<!--   Core JS Files   -->
		<script src="js/jquery.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/material.min.js"></script>
	
	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
		<script src="js/nouislider.min.js" type="text/javascript"></script>
	
	<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
		<script src="js/bootstrap-datepicker.js" type="text/javascript"></script>
	
	<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
		<script src="js/material-kit.js" type="text/javascript"></script>

</html>