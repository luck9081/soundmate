<nav class="navbar navbar-transparent navbar-fixed-top navbar-color-on-scroll">
      <div class="container">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
              <img src="${reubicacion}img/logo-sm.png" style="width:150px; margin:0px; padding-top:0px" />
          </div>

          <c:choose>
	   		<c:when test="${not empty sessionScope.username}">
	   			<div class="collapse navbar-collapse" id="navigation-example">
		            <ul class="nav navbar-nav navbar-right">
		                <li>
		                	<h5 style="font-weight:bold;">Hola ${sessionScope.username.toLowerCase()}!</h5>
		                </li>                
		                <li>
		                  <a href="http://www.twitter.com/share?url=" target="_blank" class="btn btn-simple btn-white btn-just-icon">
		                    <i class="fa fa-twitter"></i>
		                  </a>
		                </li>
		                <li>
		                  <a href="https://www.facebook.com/sharer/sharer.php?u=" target="_blank" class="btn btn-simple btn-white btn-just-icon">
		                    <i class="fa fa-facebook-square"></i>
		                  </a>
		                </li>
		                <li class="dropdown">
		                  <a href="" class="dropdown-toggle" data-toggle="dropdown">
		                  	<img src="${reubicacion}img/<c:out value="${usuario.getImagen()}"/>" class="img-circle img-responsive" style="width:30px;height:30px;margin-top:-10px;">
		                    <b class="caret"></b>
		                  </a>
		                    <ul class="dropdown-menu dropdown-menu-right">
		                        <li class="dropdown-header">Configuraci&oacute;n</li>
		                        <li><a href="${reubicacion}perfil">Mi Perfil</a></li>
		                        <li><a href="${reubicacion}mis-bandas">Mis Bandas</a></li>
		                        <li><a href="${reubicacion}busqueda">Buscar m&uacute;sicos cerca</a></li>
		                        <li class="divider"></li>
		                        <li>
		                          <a href="${reubicacion}destruir_sesion">
		                            <i class="material-icons">exit_to_app</i>Cerrar Sesión
		                          </a>
		                        </li>
		                    </ul>
		                </li>
		            </ul>
		          </div>
	   		</c:when>
	   	</c:choose>
			
      </div>
    </nav>