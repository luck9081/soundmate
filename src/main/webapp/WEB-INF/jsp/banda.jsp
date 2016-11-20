<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="${reubicacion}img/apple-icon.png">
  <link rel="icon" type="image/png" href="${reubicacion}img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title>Perfil Banda - Soundmate</title>

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
	          	  <!-- aca esta la info de perfil de la banda -->
	              <div class="profile">
	                  <div class="avatar">
	                      <img src="${reubicacion}img/default-avatar.png" alt="Circle Image" class="img-circle img-responsive img-raised">
	                  </div>
	                  <div class="name">
	                    <h3 class="title">${banda.getNombre()}</h3>
	                    <h4><i class="material-icons" style="font-size:14px;">music_note</i>${banda.getGenero()}</h4>
	                  </div>
	        		</div>
	        		<!-- fin info de perfil de la banda -->
	        	</div>
        		<div class="row" style="min-height:600px">
        		  <!-- aca esta la info de la banda -->
                  <div class="col-md-12">
                  	<div class="col-md-3">
               			<h4>Informaci&oacute;n</h4>
               			<hr style="margin:0; padding:0;">
                		<%-- <h6><i class="material-icons" style="font-size:14px;">music_note</i> Genero: Rock${sessionScope.banda.getGenero()}</h6> --%>
                		<h6>aca va una breve descripcion de la banda. inicios, influencias y todo lo que quieran contar</h6>
                		<h4>Proximas Fechas:</h4>
               			<hr style="margin:0; padding:0;">
                		<h6><i class="material-icons" style="font-size:14px;">date_range</i> 09/12 - Ramos Mejía</h6>
                		<h6><i class="material-icons" style="font-size:14px;">date_range</i> 16/12 - Castelar</h6>
                  	</div>
                  	<!-- fin info de la banda -->
                  	
                  	<div class="col-md-9">
                  		
                  		<!-- form para publicar comments en el muro de la banda -->
               			<form:form id="publicacion" modelAttribute="publicar" method="POST" action="../postear/${banda.getNombre()}">
               				<form:textarea path="descripcion" class="form-control" placeholder="Escribi acá tu publicacion..." rows="5" />
               				<form:button type="submit" class="btn btn-primary btn-raised">
               					Publicar
               				</form:button>
               			</form:form>
               		</div>
               		<div class="col-md-3">
               		</div>
               		<div class="col-md-9">
               			<h4>Publicaciones</h4>
                  		<hr style="margin:0; padding:0;">
                  		<!-- Aca arrancan las publicaciones de miembros y users -->
               			<div style="padding-top:2%" class="row">
               				
               				<div class="col-md-11">
         						<c:forEach var="item" items="${publicaciones}">
         							<div class="col-md-1">
               							<img src="${reubicacion}img/default-avatar.png" class="img-circle img-responsive">
               						</div>
									<p><c:out value="${item.usuario.getNombre()}"/> - <c:out value="${item.fechaPublicacion}"/></p>
   									<p><c:out value="${item.descripcion}"/></p>
								</c:forEach>
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
