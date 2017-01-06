package ar.edu.grupoesfera.cursospring.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.AmigoService;
import ar.edu.grupoesfera.cursospring.interfaces.PerfilService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.modelo.UsuarioEsAmigo;

@Transactional
@Controller
@Scope("session")
public class AmigosController {
	
	@Inject
	public PerfilService perfilService;
	
	@Inject
	public AmigoService amigoService;
	
	@RequestMapping("/agregarAAmigos/{username}")
	public ModelAndView agregarAAmigos(@PathVariable("username") String nombreUsuario, HttpServletRequest request){
		
		Usuario amigo = perfilService.buscarPerfilUsuario(nombreUsuario);
		Usuario miUsuario = perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username")); // A la busqueda de perfil de usuario le paso el atributo de session (casteado a string).
		List<UsuarioEsAmigo> listaDeSolicitudDeAmistad =amigoService.buscarSolicitudesDeAmistad(miUsuario);
		
		amigoService.agregarAListaDeAmigos((long)request.getSession().getAttribute("id"), amigo.getIdusuario());
		
		ModelMap agregarAAmigos = new ModelMap();
		
		agregarAAmigos.addAttribute("listaDeSolicitudDeAmistad", listaDeSolicitudDeAmistad);
		agregarAAmigos.addAttribute("title","Agregar a amigos");
		agregarAAmigos.addAttribute("titulo","Enhorabuena, has agregado un nuevo amigo");
		agregarAAmigos.addAttribute("subtitulo","Ya le hemos enviado tu solicitud de amistad");
		agregarAAmigos.addAttribute("inputValue","Volver al perfil");
		agregarAAmigos.addAttribute("inputHref","../perfil");
		agregarAAmigos.addAttribute("iconClass","fa fa-chevron-left");
		agregarAAmigos.addAttribute("reubicacion","../");

		
		return new ModelAndView("landing",agregarAAmigos);
	}
	
	@RequestMapping("/eliminarSolicitudDeAmistad/{username}")
	public ModelAndView eliminarSolicitudDeAmistad(@PathVariable("username") String nombreUsuario, HttpServletRequest request){
			
		Usuario amigo = perfilService.buscarPerfilUsuario(nombreUsuario);
		Usuario miUsuarioLogueado=perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username"));
		List<UsuarioEsAmigo> listaDeSolicitudDeAmistad =amigoService.buscarSolicitudesDeAmistad(miUsuarioLogueado);

		amigoService.eliminarAmigos(miUsuarioLogueado, amigo);
			
		ModelMap eliminarAmigos = new ModelMap();

		eliminarAmigos.addAttribute("listaDeSolicitudDeAmistad", listaDeSolicitudDeAmistad);
		eliminarAmigos.addAttribute("title","Eliminar solicitud");
		eliminarAmigos.addAttribute("titulo","Enhorabuena, has eliminado una solicitud de amistad");
		eliminarAmigos.addAttribute("subtitulo","Sigue navengando en Soundmate");
		eliminarAmigos.addAttribute("inputValue","Volver al perfil");
		eliminarAmigos.addAttribute("inputHref","../perfil");
		eliminarAmigos.addAttribute("iconClass","fa fa-chevron-left");
		eliminarAmigos.addAttribute("reubicacion","../");
	
			
		return new ModelAndView("landing",eliminarAmigos);
	}	
	
	@RequestMapping("/eliminarAmigos/{username}")
	public ModelAndView eliminarAmigos(@PathVariable("username") String nombreUsuario, HttpServletRequest request){
			
		Usuario amigo = perfilService.buscarPerfilUsuario(nombreUsuario);
		Usuario miUsuarioLogueado=perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username"));
		List<UsuarioEsAmigo> listaDeSolicitudDeAmistad =amigoService.buscarSolicitudesDeAmistad(miUsuarioLogueado);

		
		amigoService.eliminarAmigos(miUsuarioLogueado, amigo);
			
		ModelMap eliminarAmigos = new ModelMap();

		eliminarAmigos.addAttribute("listaDeSolicitudDeAmistad", listaDeSolicitudDeAmistad);
		eliminarAmigos.addAttribute("title","Eliminar amigo");
		eliminarAmigos.addAttribute("titulo","Enhorabuena, has eliminado un amigo");
		eliminarAmigos.addAttribute("subtitulo","Sigue navengando en Soundmate");
		eliminarAmigos.addAttribute("inputValue","Volver al perfil");
		eliminarAmigos.addAttribute("inputHref","../perfil");
		eliminarAmigos.addAttribute("iconClass","fa fa-chevron-left");
		eliminarAmigos.addAttribute("reubicacion","../");
	
			
		return new ModelAndView("landing",eliminarAmigos);
	}
		


	@RequestMapping("/aceptarSolicitudDeAmistad/{username}")
	public ModelAndView aceptarSolicitudDeAmistad(@PathVariable("username") String nombreUsuario, HttpServletRequest request){
			
		Usuario amigo = perfilService.buscarPerfilUsuario(nombreUsuario);
		Usuario miUsuarioLogueado=perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username"));
		List<UsuarioEsAmigo> listaDeSolicitudDeAmistad =amigoService.buscarSolicitudesDeAmistad(miUsuarioLogueado);
		
		amigoService.aceptarSolicitudDeAmistad(miUsuarioLogueado, amigo);
			
		ModelMap eliminarAmigos = new ModelMap();
		
		eliminarAmigos.addAttribute("listaDeSolicitudDeAmistad", listaDeSolicitudDeAmistad);
		eliminarAmigos.addAttribute("title","Aceptar Solicitud");
		eliminarAmigos.addAttribute("titulo","Enhorabuena, te has echo de un nuevo amigo");
		eliminarAmigos.addAttribute("subtitulo","Sigue navengando en Soundmate");
		eliminarAmigos.addAttribute("inputValue","Volver al perfil");
		eliminarAmigos.addAttribute("inputHref","../perfil");
		eliminarAmigos.addAttribute("iconClass","fa fa-chevron-left");
		eliminarAmigos.addAttribute("reubicacion","../");
	
			
		return new ModelAndView("landing",eliminarAmigos);
	}	
	
	@RequestMapping("/perfil/eliminarSolicitudDeAmistad/{username}")
	public ModelAndView redirectEliminarSolicitudDeAmistad(){
		return new ModelAndView("redirect:/eliminarSolicitudDeAmistad/{username}");	
	}
	
	@RequestMapping("/perfil/aceptarSolicitudDeAmistad/{username}")
	public ModelAndView redirectAceptarSolicitudDeAmistad(){
		return new ModelAndView("redirect:/aceptarSolicitudDeAmistad/{username}");	
	}
}
