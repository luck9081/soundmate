package ar.edu.grupoesfera.cursospring.controladores;


//imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.servicios.UsuarioService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.annotation.Scope;

@Controller
@Scope("session")
public class Controlador {
	
	@Inject
	private UsuarioService miUsuarioService;
	
	//setter para crear el servicio mockeado
	public void setUsuarioServiceMock(UsuarioService servicioMock){
		 this.miUsuarioService=servicioMock;
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup(){
		
		ModelMap registro = new ModelMap();
		Usuario usuario = new Usuario();
		registro.addAttribute(usuario);
		return new ModelAndView("signup", registro);
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		
		ModelMap login = new ModelMap();
		Usuario usuario = new Usuario();
		login.addAttribute(usuario);

		return new ModelAndView("login", login);
	}
	
	@RequestMapping("/perfil")
	public ModelAndView perfil() {

		return new ModelAndView("profile");
	}
	
	@RequestMapping(path="/registro", method = RequestMethod.POST)
	public ModelAndView crearUsuario( @ModelAttribute("usuario") @Valid Usuario usuario,BindingResult result, HttpServletRequest request){
		
		if(result.hasErrors()){	
			return new ModelAndView("signup");
		}else{
			ModelMap mapa=miUsuarioService.registrarUsuario(usuario);
			request.getSession().setAttribute("user",usuario);
			return new ModelAndView("profile", mapa);
		}
		
	}
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public ModelAndView ingresoUsuario(@ModelAttribute("usuario") Usuario usuario){ 
			
		ModelMap ingresoUser=miUsuarioService.ingresarUsuario(usuario);
		
			return new ModelAndView("profile", ingresoUser);
	}
	

	@RequestMapping(path="/destruir_sesion")
	public ModelAndView destruirSesion(HttpServletRequest request){
		
		ModelMap login = new ModelMap();
		Usuario usuario = new Usuario();
		login.addAttribute(usuario);
		
		request.removeAttribute("user");
		
		return new ModelAndView("login",login);
	}
	
	@RequestMapping(path="/misbandas")
	public ModelAndView misbandas(){
		
		ModelMap misbandas=new ModelMap();
		Usuario usuario=new Usuario();
		misbandas.addAttribute(usuario);
		
		return new ModelAndView("mybands",misbandas);
	}

	
}