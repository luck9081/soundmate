package ar.edu.grupoesfera.cursospring.controladores;

//imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
public class RegistroController {

	
	@RequestMapping("/signup")
	public ModelAndView signup(){
		
		return new ModelAndView("signup");
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {

		return new ModelAndView("login");
	}
	
	@RequestMapping("/perfil")
	public ModelAndView perfil() {

		return new ModelAndView("profile");
	}
	
	@RequestMapping(path="/registro", method = RequestMethod.POST)
	public ModelAndView crearUsuario(@ModelAttribute("usuario") Usuario usuario){ 
			
			ModelMap modelCrearUser = new ModelMap();
			modelCrearUser.put("username", usuario.getNombre());
			modelCrearUser.put("email", usuario.getEmail());
			modelCrearUser.put("pass", usuario.getPass());
			modelCrearUser.put("instrumento", usuario.getInstrumento());
			
			return new ModelAndView("/perfil", modelCrearUser);
	}
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public ModelAndView ingresoUsuario(@ModelAttribute("usuario") Usuario usuario){ 
			
			ModelMap ingresoUser = new ModelMap();
			ingresoUser.put("username", usuario.getNombre());
			ingresoUser.put("pass", usuario.getPass());
			
			return new ModelAndView("/perfil", ingresoUser);
	}
	
}