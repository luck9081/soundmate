package ar.edu.grupoesfera.cursospring.controladores;


//imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.RegistroService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;

@Controller
@Scope("session")
public class RegistroController {
	
	@Inject
	public RegistroService registroService;
	
	@RequestMapping("/signup")
	public ModelAndView signup(){
		
		Usuario usuario = new Usuario();
		
		ModelMap registro = new ModelMap();
		registro.addAttribute(usuario);
		
		return new ModelAndView("signup", registro);
	}
	
	@RequestMapping(path="/registro", method = RequestMethod.POST)
	public ModelAndView crearUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request){ 
			
			ModelMap resultado = new ModelMap();
			
			if(registroService.registrarUsuario(usuario)){
				
				resultado.addAttribute("titulo","¡Ya estás registrado!");
				resultado.addAttribute("subtitulo","Hacé click en el link de abajo y comenzá a disfrutar del increíble mundo de Soundmate :)");
				resultado.addAttribute("inputValue","Continuar");
				resultado.addAttribute("inputHref","login");
				resultado.addAttribute("iconClass","fa fa-chevron-right");
				
				return new ModelAndView("landing",resultado);
			}
			
			else {
				
				resultado.addAttribute("titulo","¡Ups! No ha salido bien");
				resultado.addAttribute("subtitulo","Parece que existe un usuario con mismo nombre/email. No te preocupes, ¡volvé a intentarlo!");
				resultado.addAttribute("inputValue","Volver a Registrarse");
				resultado.addAttribute("inputHref","signup");
				resultado.addAttribute("iconClass","fa fa-chevron-left");
				
				return new ModelAndView("landing",resultado);
			}
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		
		Usuario usuario = new Usuario();
		
		ModelMap login = new ModelMap();
		login.addAttribute(usuario);

		return new ModelAndView("login", login);
	}
	
	@RequestMapping(path="/loguearse", method = RequestMethod.POST)
	public ModelAndView ingresoUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request){ 
			
			ModelMap login = new ModelMap();
		
			if(registroService.loguearUsuario(usuario)){
				
				request.getSession().setAttribute("username", usuario.getNombre());
				
				return new ModelAndView("redirect:/perfil");
			}
			
			else{
				login.addAttribute("titulo","¡Ups! No ha salido bien");
				login.addAttribute("subtitulo","Parece que no ingresaste correctamente tu usuario/contraseña. No te preocupes, ¡volvé a intentarlo!");
				login.addAttribute("inputValue","Volver a Ingresar");
				login.addAttribute("inputHref","login");
				login.addAttribute("iconClass","fa fa-chevron-left");
				
				return new ModelAndView("landing",login);
			}
	}
	
	@RequestMapping(path="/destruir_sesion")
	public ModelAndView destruirSesion(HttpServletRequest request){
		
		ModelMap login = new ModelMap();
		Usuario usuario = new Usuario();
		login.addAttribute(usuario);
		
		request.getSession().removeAttribute("user");
		
		return new ModelAndView("login",login);
	}
	
}