package ar.edu.grupoesfera.cursospring.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.PerfilService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
@Scope("session")
public class PerfilController {
	
	@Inject
	public PerfilService perfilService;
	
	/* ------ MOSTRAR PERFIL PROPIO ------ */
	
	@RequestMapping("/perfil")
	public ModelAndView perfil(HttpServletRequest request) {
		
		Usuario miUsuario = perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username")); // A la busqueda de perfil de usuario le paso el atributo de session (casteado a string).
		
		ModelMap perfil = new ModelMap();
		perfil.addAttribute("usuario",miUsuario);
		
		return new ModelAndView("profile",perfil);
	}
	
	/* ------ BUSCAR PERFIL PUBLICO ------ */
	
	@RequestMapping("/perfil/{username}")
	public ModelAndView perfilUser(@PathVariable("username") String nombreUsuario, HttpServletRequest request){		

		Usuario usuarioEncontrado = perfilService.buscarPerfilUsuario(nombreUsuario);
		
		ModelMap perfil = new ModelMap();
		perfil.addAttribute("usuario",usuarioEncontrado);
		perfil.addAttribute("reubicacion","../");	// String necesario para que todos los recursos css, js, imagenes y backgrounds tengan su "src" correctamente (a causa del PathVariable)
		
		return new ModelAndView("profile",perfil);		
	}
	
	/* ------ EDITAR PERFIL PROPIO ------ */
	
	@RequestMapping("/editarPerfil")
	public ModelAndView editar() {
		return new ModelAndView("profileEdit");
	}
}
