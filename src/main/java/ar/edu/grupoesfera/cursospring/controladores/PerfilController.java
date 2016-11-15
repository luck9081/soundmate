package ar.edu.grupoesfera.cursospring.controladores;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
public class PerfilController {
	
	@RequestMapping("/perfil")
	public ModelAndView perfil() {

		return new ModelAndView("profile");
	}
	
	@RequestMapping("/editarPerfil")
	public ModelAndView editar() {

		return new ModelAndView("profileEdit");
	}
	
	@RequestMapping("/perfil/{username}")
	public ModelAndView perfilUser(@PathVariable("username") String username){		
		return new ModelAndView("profile");		
	}
}
