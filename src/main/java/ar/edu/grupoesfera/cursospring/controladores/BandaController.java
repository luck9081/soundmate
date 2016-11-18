package ar.edu.grupoesfera.cursospring.controladores;

import java.util.List;

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

import ar.edu.grupoesfera.cursospring.interfaces.BandaService;
import ar.edu.grupoesfera.cursospring.interfaces.PerfilService;
import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
@Scope("session")
public class BandaController {
	
	@Inject
	public PerfilService perfilService;
	
	@RequestMapping(path="/banda/{nombreBanda}")
	public ModelAndView perfilUser(@PathVariable("nombreBanda") String nombreBanda, HttpServletRequest request){
		
		Banda miBanda = perfilService.buscarPerfilBanda(nombreBanda); // A la busqueda de banda le paso el atributo de session (casteado a string).
		
		
		ModelMap perfilBanda = new ModelMap();

		perfilBanda.addAttribute(miBanda);
		perfilBanda.addAttribute("reubicacion","../");	// String necesario para que todos los recursos css, js, imagenes y backgrounds tengan su "src" correctamente (a causa del PathVariable)
		
		return new ModelAndView("banda",perfilBanda);
	}
	
	@Inject BandaService bandaService;
	
	@RequestMapping(path="/mis-bandas")
	public ModelAndView misbandas(HttpServletRequest request){
		
		ModelMap misbandas=new ModelMap();
		Banda banda = bandaService.consultarBandas((String)request.getSession().getAttribute("username"));
		misbandas.addAttribute("banda", banda);
		
		return new ModelAndView("misBandas",misbandas);
	}
	
	
	
	@RequestMapping(path="/registrarBanda", method = RequestMethod.POST)
	public ModelAndView crearBanda(@ModelAttribute("banda") Banda banda){ 
			
			ModelMap modelCrearBanda = new ModelMap();
			modelCrearBanda.addAttribute("titulo","�Banda registrada!");
			modelCrearBanda.addAttribute("subtitulo","Hac� click en el link de abajo y comenz� a disfrutar del incre�ble mundo de Soundmate :)");
			modelCrearBanda.addAttribute("inputValue","ir a banda");
			modelCrearBanda.addAttribute("inputHref","banda/"+banda.getNombre());
			modelCrearBanda.addAttribute("iconClass","fa fa-chevron-right");		
			bandaService.registrarBanda(banda);
			
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
