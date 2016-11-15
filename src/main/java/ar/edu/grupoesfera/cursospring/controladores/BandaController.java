package ar.edu.grupoesfera.cursospring.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
@Scope("session")
public class BandaController {
	
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
	
	@RequestMapping(path="/registroBanda", method = RequestMethod.POST)
	public ModelAndView crearBanda(@ModelAttribute("banda") Banda banda, HttpServletRequest request){ 
			
			ModelMap modelCrearBanda = new ModelMap();
			modelCrearBanda.put("nombre", banda.getNombre());
			modelCrearBanda.put("genero", banda.getGenero());			
			request.getSession().setAttribute("banda",banda);
			
			return new ModelAndView("landing-registro", modelCrearBanda);
	}
	
	@RequestMapping("/crear-banda")
	public ModelAndView nuevaBanda(){
		ModelMap registroBanda = new ModelMap();
		Banda banda = new Banda();
		registroBanda.addAttribute(banda);
		return new ModelAndView("registroBanda", registroBanda);
	}
	
}
