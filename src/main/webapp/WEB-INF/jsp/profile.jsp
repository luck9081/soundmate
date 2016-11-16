<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
  <link rel="icon" type="image/png" href="img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title>Perfil - Soundmate</title>

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

  <!--     Fonts and icons     -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" type="text/css"/>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" type="text/css"/>

  <!-- CSS Files -->
    <link href="${reubicacion}css/bootstrap.min.css" rel="stylesheet" />
    <link href="${reubicacion}css/material-kit.css" rel="stylesheet"/>

</head>

<body class="profile-page">
	<%@ include file="../includes/menu.jsp" %>

  	<div class="wrapper">
  		
    	<div class="header header-filter" style="background-image: url('${reubicacion}img/bg-concert.jpg');"></div>
	    <div class="main main-raised">
	      <div class="profile-content">
	      	<div class="container">
	          <div class="row">
	              <div class="profile">
	                  <div class="avatar">
	                      <img src="${reubicacion}img/default-avatar.png" alt="Circle Image" class="img-circle img-responsive img-raised">
	                  </div>
	                  <div class="name">
	                    <h3 class="title">${usuario.getNombre().toUpperCase()}</h3>
	                    <h6><i class="material-icons" style="font-size:14px;">location_on</i> ${usuario.getLocalidad()}</h6>
	        		  </div>
	        		</div>
	        		
	        		<c:choose>
						<c:when test="${usuario.getIdusuario() == sessionScope.user.getIdusuario()}">
							<a href="${reubicacion}editarPerfil" style="float:right" class="btn btn-primary btn-raised">Editar</a>
						</c:when>
						<c:otherwise>
					        <a href="" style="float:right" class="btn btn-primary btn-raised">Añadir a Banda</a>
					    </c:otherwise>
					</c:choose>
	        		
	        	</div>
        		<div class="row" style="padding-bottom: 80px;">
                  <div class="col-md-12">
                  	<div class="col-md-3">
                  	
 						<div style="text-align:left; border:20pt; border-color:#f1f1f2">
                  			<h4>Infuencias</h4>
                  			<hr style="margin:0; padding:0;">
	                  		<p>Radiohead, Rolling Stones, The Strokes</p>
	                  	</div>                 	
                  		<div style="text-align:left; border:20pt; border-color:#f1f1f2">
                  			<h4>Informaci&oacute;n</h4>
                  			<hr style="margin:0; padding:0;">
	                  		<h6><i class="material-icons" style="font-size:14px;">email</i> ${usuario.getEmail()}</h6>
	                  		<h6><i class="material-icons" style="font-size:14px;">music_note</i> ${usuario.getInstrumento()}</h6>
	                  		<h6><i class="material-icons" style="font-size:14px;">date_range</i> 16 de Junio</h6>
	                  		<h6><i class="material-icons" style="font-size:14px;">people</i> Soundmate </h6>
	                  	</div>	                  	
	                  	
                  	</div>
                  	
                  	<div class="col-md-9">
		                  		
		                  		<c:choose>
									<c:when test="${usuario.getIdusuario() == sessionScope.user.getIdusuario()}">
										<!-- form para publicar comments en el muro -->
				               			<form id="publicacion">
				               				<textarea class="form-control" placeholder="Escribi acá tu publicacion..." rows="5"></textarea>
				               				<button type="submit" class="btn btn-primary btn-raised">
				               					Publicar
				               				</button>
				               			</form>
									</c:when>
								</c:choose>
		               			
		               			<h4>Publicaciones</h4>
		                  		<hr style="margin:0; padding:0;">
		                  		<!-- Aca arrancan las publicaciones de users -->
		               			<div style="padding-top:2%" class="row">
		               				<div class="col-md-1">
		               					<img src="${reubicacion}img/tincho.jpg" class="img-circle img-responsive">
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
  <script src="${reubicacion}js/jquery.min.js" type="text/javascript"></script>
  <script src="${reubicacion}js/bootstrap.min.js" type="text/javascript"></script>
  <script src="${reubicacion}js/material.min.js"></script>

  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="${reubicacion}js/nouislider.min.js" type="text/javascript"></script>

  <!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
  <script src="${reubicacion}js/bootstrap-datepicker.js" type="text/javascript"></script>

  <!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
  <script src="${reubicacion}js/material-kit.js" type="text/javascript"></script>

</html>
