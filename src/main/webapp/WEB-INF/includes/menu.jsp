<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
              <img src="${reubicacion}img/logo-sm.png" style="width:150px; margin:0px; padding-left:20px" />
          </div>

          <c:choose>
	   		<c:when test="${not empty sessionScope.username}">
	   			<div class="collapse navbar-collapse" id="navigation-example">
		            <ul class="nav navbar-nav navbar-right">
		            	<li class="dropdown">
							<a href="" class="dropdown-toggle" data-toggle="dropdown">
								<i class="material-icons">share</i>
							</a>
			            	<ul class="dropdown-menu dropdown-menu-right">              
				      		 <li>
				                  <a href="http://www.twitter.com/share?url=" target="_blank" class="btn-simple">
				                    <i class="fa fa-twitter"></i> Twitter
				                  </a>
				                </li>
				                <li>
				                  <a href="https://www.facebook.com/sharer/sharer.php?u=" target="_blank" class="btn-simple">
				                    <i class="fa fa-facebook-square"></i> Facebook
				                  </a>
				                </li>
				                <li>
				                  <a href="https://www.facebook.com/sharer/sharer.php?u=" target="_blank" class="btn-simple">
				                    <i class="fa fa-soundcloud"></i> Soundcloud
				                  </a>
				                </li>
				                <li>
				                  <a href="https://www.facebook.com/sharer/sharer.php?u=" target="_blank" class="btn-simple">
				                    <i class="fa fa-bandcamp"></i> Bandcamp
				                  </a>
				                </li>
				            </ul>
				        </li>
		            	<li class="dropdown">
							<a href="" class="dropdown-toggle" data-toggle="dropdown">
								<i class="material-icons">supervisor_account</i>
							</a>
			            	<ul class="dropdown-menu dropdown-menu-right">
			            	<c:forEach var="item" items="${listaDeSolicitudDeAmistad}">
				            	<c:choose>
				            	
					            	<c:when test="${item.getEstado()==-1}">
					            		<li><a href="${reubicacion}perfil/${item.getAmigo().getNombre()}"><c:out value="${item.getAmigo().getNombre()}"></c:out></a><a href="./aceptarSolicitudDeAmistad/${item.getAmigo().getNombre()}"><button>Aceptar</button></a><a href="./eliminarSolicitudDeAmistad/${item.getAmigo().getNombre()}"><button>Rechazar</button></a></li>
					            	</c:when>
				            	
				            	</c:choose>
			            	</c:forEach>
				              <li><a href="">Ver mis amigos</a></li>
				            </ul>
				        </li>		            	

		                <li class="dropdown">
		                	
							<a href="" class="dropdown-toggle" data-toggle="dropdown">
							   	<img src="${reubicacion}img/${sessionScope.imagen}" class="img-circle" style="width:30px; margin-top:-5px" />
							   	<b style="margin-left:5px">${sessionScope.username.toUpperCase()}</b>
							   	<span class="caret"></span>
							</a>
		                    <ul class="dropdown-menu dropdown-menu-right">

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