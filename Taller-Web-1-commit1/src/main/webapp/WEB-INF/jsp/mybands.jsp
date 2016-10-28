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
    	<div class="header header-filter" style="background-image: url('img/examples/city.jpg');"></div>
	    <div class="main main-raised">
	      <div class="profile-content">
	      	<div class="container">
	          <div class="row">
	              <div class="profile">
	                 <!--   <div class="avatar">
	                      <img src="img/christian.jpg" alt="Circle Image" class="img-circle img-responsive img-raised">
	                  </div>-->
	                <!--    <div class="name">
	                    <h3 class="title">${sessionScope.user.getNombre()}</h3>
	        			<h6><i class="material-icons" style="font-size:14px;">email</i>${sessionScope.user.getEmail()} | <i class="material-icons" style="font-size:14px;">music_note</i>${sessionScope.user.getInstrumento()} | <i class="material-icons" style="font-size:14px;">location_on</i></span> ${sessionScope.user.getLocalidad()}</h6>
	                  </div>-->
	              </div>
	          </div>
	          <div class="content_misbandas">
	               <h3>Banda 1</h3>
	               <ul class="ul_misbandas">
	               		<li class="li_misbandas">Integrante1/  </li>
	               		<li class="li_misbandas">Integrante2/  </li>
	               		<li class="li_misbandas">Integrante3/  </li>
	               		<li class="li_misbandas">Integrante4/  </li><br>
	               </ul>
	                <h3>Banda 2</h3>
	               <ul class="ul_misbandas">
	               		<li class="li_misbandas">Integrante1/  </li>
	               		<li class="li_misbandas">Integrante2/ </li>
	               		<li class="li_misbandas">Integrante3/ </li>
	               		<li class="li_misbandas">Integrante4/ </li>
	               </ul>
	              <!--    <h3>Banda 3</h3>
	               <ul>
	               		<li class="li_misbandas">Integrante1/  </li>
	               		<li class="li_misbandas">Integrante2/  </li>
	               		<li class="li_misbandas">Integrante3/  </li>
	               		<li class="li_misbandas">Integrante4/  </li>
	               </ul>-->
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