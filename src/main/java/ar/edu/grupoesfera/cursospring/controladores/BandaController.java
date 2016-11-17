package ar.edu.grupoesfera.cursospring.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.PerfilService;
import ar.edu.grupoesfera.cursospring.interfaces.RegistrarBandaService;
import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
@Scope("session")
public class BandaController {
	
	@Inject
	public PerfilService perfilService;
	
	@RequestMapping(path="/banda/{nombreBanda}")
	public ModelAndView perfilUser(@PathVariable("nombreBanda") String nombreBanda, HttpServletRequest request){
		
		Banda miBanda = perfilService.buscarPerfilBanda(nombreBanda); // A la busqueda de perfil de usuario le paso el atributo de session (casteado a string).
		
		
		ModelMap perfilBanda = new ModelMap();

		perfilBanda.addAttribute(miBanda);
		perfilBanda.addAttribute("reubicacion","../");	// String necesario para que todos los recursos css, js, imagenes y backgrounds tengan su "src" correctamente (a causa del PathVariable)
		
		return new ModelAndView("banda",perfilBanda);
	}
	
	
	@RequestMapping(path="/mis-bandas")
	public ModelAndView misbandas(){
		
		ModelMap misbandas=new ModelMap();
		Usuario usuario=new Usuario();
		misbandas.addAttribute(usuario);
		
		return new ModelAndView("misBandas",misbandas);
	}
	
	@Inject RegistrarBandaService registroBanda;
	
	@RequestMapping(path="/registrarBanda", method = RequestMethod.POST)
	public ModelAndView crearBanda(@ModelAttribute("banda") Banda banda){ 
			
			ModelMap modelCrearBanda = new ModelMap();
			modelCrearBanda.addAttribute("titulo","¡Ya estás registrado!");
			modelCrearBanda.addAttribute("subtitulo","Hacé click en el link de abajo y comenzá a disfrutar del increíble mundo de Soundmate :)");
			modelCrearBanda.addAttribute("inputValue","Continuar");
			modelCrearBanda.addAttribute("inputHref","banda");
			modelCrearBanda.addAttribute("iconClass","fa fa-chevron-right");		
			registroBanda.registrarBanda(banda);
			
			return new ModelAndView("landing", modelCrearBanda);
	}
	
	@RequestMapping("/crear-banda")
	public ModelAndView nuevaBanda(){
		ModelMap registroBanda = new ModelMap();
		Banda banda = new Banda();
		registroBanda.addAttribute(banda);
		return new ModelAndView("registroBanda", registroBanda);
	}
	
}
