package ar.edu.grupoesfera.cursospring.controladores;


//imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;

@Controller
@Scope("session")
public class RegistroController {
	
	@RequestMapping("/perfil/{username}")
	public ModelAndView perfilUser(@PathVariable("username") String username){
		
		return new ModelAndView("profile");
		
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup(){
		ModelMap registro = new ModelMap();
		Usuario usuario = new Usuario();
		registro.addAttribute(usuario);
		return new ModelAndView("signup", registro);
	}
	
	@RequestMapping("/crear-banda")
	public ModelAndView nuevaBanda(){
		ModelMap registroBanda = new ModelMap();
		Banda banda = new Banda();
		registroBanda.addAttribute(banda);
		return new ModelAndView("registroBanda", registroBanda);
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
	
	@RequestMapping("/editarPerfil")
	public ModelAndView editar() {

		return new ModelAndView("profileEdit");
	}
	
	
	@RequestMapping(path="/registro", method = RequestMethod.POST)
	public ModelAndView crearUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request){ 
			
			ModelMap modelCrearUser = new ModelMap();
			modelCrearUser.put("nombre", usuario.getNombre());
			modelCrearUser.put("email", usuario.getEmail());
			modelCrearUser.put("pass", usuario.getPass());
			modelCrearUser.put("instrumento", usuario.getInstrumento());
			modelCrearUser.put("localidad", usuario.getLocalidad());
			modelCrearUser.put("partido", usuario.getPartido());
			modelCrearUser.put("provincia", usuario.getProvincia());			
			request.getSession().setAttribute("user",usuario);
			
			return new ModelAndView("landing-registro", modelCrearUser);
	}
	
	@RequestMapping(path="/registroBanda", method = RequestMethod.POST)
	public ModelAndView crearBanda(@ModelAttribute("banda") Banda banda, HttpServletRequest request){ 
			
			ModelMap modelCrearBanda = new ModelMap();
			modelCrearBanda.put("nombre", banda.getNombre());
			modelCrearBanda.put("genero", banda.getGenero());			
			request.getSession().setAttribute("banda",banda);
			
			return new ModelAndView("landing-registro", modelCrearBanda);
	}
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public ModelAndView ingresoUsuario(@ModelAttribute("usuario") Usuario usuario){ 
			
			ModelMap ingresoUser = new ModelMap();
			ingresoUser.put("nombre", usuario.getNombre());
			ingresoUser.put("pass", usuario.getPass());
			
			return new ModelAndView("profile", ingresoUser);
	}
	
	@RequestMapping(path="/destruir_sesion")
	public ModelAndView destruirSesion(HttpServletRequest request){
		
		ModelMap login = new ModelMap();
		Usuario usuario = new Usuario();
		login.addAttribute(usuario);
		
		request.getSession().removeAttribute("user");
		
		return new ModelAndView("login",login);
	}
	

	@RequestMapping(path="/banda")
	public ModelAndView perfilBanda(){
		
		ModelMap perfilBanda = new ModelMap();
		Banda banda = new Banda();
		perfilBanda.addAttribute(banda);
		
		return new ModelAndView("banda",perfilBanda);
	}
	
	
	@RequestMapping(path="/bandas")
	public ModelAndView misbandas(){
		
		ModelMap misbandas=new ModelMap();
		Usuario usuario=new Usuario();
		misbandas.addAttribute(usuario);
		
		return new ModelAndView("misBandas",misbandas);
	}
	
}