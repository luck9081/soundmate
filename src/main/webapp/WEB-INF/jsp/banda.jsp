
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
  <link rel="icon" type="image/png" href="img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title>Perfil Banda - Soundmate</title>

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

  <!--     Fonts and icons     -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

  <!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/material-kit.css" rel="stylesheet"/>

</head>

<body class="profile-page">
	<%@ include file="../includes/menu.jsp" %>

  	<div class="wrapper">
    	<div class="header header-filter" style="background-image: url('img/bg-concert.jpg');"></div>
	    <div class="main main-raised">
	      <div class="profile-content">
	      	<div class="container">
	          <div class="row">
	          	  <!-- aca esta la info de perfil de la banda -->
	              <div class="profile">
	                  <div class="avatar">
	                      <img src="img/default-avatar.png" alt="Circle Image" class="img-circle img-responsive img-raised">
	                  </div>
	                  <div class="name">
	                    <h3 class="title">Soundmate${sessionScope.banda.getNombre()}</h3>
	                    <h4>Rodri (Bajo y Voz) | Lucas (Guitarra) | Tincho (Batería)</h4>
	                  </div>
	        		</div>
	        		<!-- fin info de perfil de la banda -->
	        	</div>
        		<div class="row">
        		  <!-- aca esta la info de la banda -->
                  <div class="col-md-12">
                  	<div class="col-md-3">
               			<h4>Informaci&oacute;n</h4>
               			<hr style="margin:0; padding:0;">
                		<h6><i class="material-icons" style="font-size:14px;">music_note</i> Genero: Rock${sessionScope.banda.getGenero()}</h6>
                		<h6>aca va una breve descripcion de la banda. inicios, influencias y todo lo que quieran contar</h6>
                		<h4>Proximas Fechas:</h4>
               			<hr style="margin:0; padding:0;">
                		<h6><i class="material-icons" style="font-size:14px;">date_range</i> 09/12 - Ramos Mejía</h6>
                		<h6><i class="material-icons" style="font-size:14px;">date_range</i> 16/12 - Castelar</h6>
                  	</div>
                  	<!-- fin info de la banda -->
                  	
                  	<div class="col-md-9">
                  		
                  		<!-- form para publicar comments en el muro de la banda -->
               			<form id="publicacion">
               				<textarea class="form-control" placeholder="Escribi acá tu publicacion..." rows="5"></textarea>
               				<button type="submit" class="btn btn-primary btn-raised">
               					Publicar
               				</button>
               			</form>
               			
               			<h4>Publicaciones</h4>
                  		<hr style="margin:0; padding:0;">
                  		<!-- Aca arrancan las publicaciones de miembros y users -->
               			<div style="padding-top:2%" class="row">
               				<div class="col-md-1">
               					<img src="img/tincho.jpg" class="img-circle img-responsive">
               				</div>
               				<div class="col-md-11">
               					<p>Tincho - 12/11/16 15:00hs</p>
               					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
               				</div>
               			</div>
                  	 </div>
                  </div>
              	</div>
	          </div>
	         </div>
	       </div>
	    </div>
    
	<%@ include file="../includes/pie.jsp" %>
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
