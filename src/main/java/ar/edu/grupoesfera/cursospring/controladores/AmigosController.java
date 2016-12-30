package ar.edu.grupoesfera.cursospring.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.AmigoService;
import ar.edu.grupoesfera.cursospring.interfaces.PerfilService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
@Scope("session")
public class AmigosController {
	
	@Inject
	public PerfilService perfilService;
	
	@Inject
	public AmigoService agregarAAmigos;
	
	@RequestMapping("/agregarAAmigos/{username}")
	public ModelAndView agregarAAmigos(@PathVariable("username") String nombreUsuario, HttpServletRequest request){
		
		Usuario amigo = perfilService.buscarPerfilUsuario(nombreUsuario);
		
		agregarAAmigos.agregarAListaDeAmigos((long)request.getSession().getAttribute("id"), amigo.getIdusuario());
		
		ModelMap agregarAAmigos = new ModelMap();
		
		agregarAAmigos.addAttribute("title","Agregar a amigos");
		agregarAAmigos.addAttribute("titulo","Enhorabuena, has agregado un nuevo amigo");
		agregarAAmigos.addAttribute("subtitulo","Ya le hemos enviado tu solicitud de amistad");
		agregarAAmigos.addAttribute("inputValue","Volver al perfil");
		agregarAAmigos.addAttribute("inputHref","../perfil");
		agregarAAmigos.addAttribute("iconClass","fa fa-chevron-left");
		agregarAAmigos.addAttribute("reubicacion","../");

		
		return new ModelAndView("landing",agregarAAmigos);
	}
	
}
