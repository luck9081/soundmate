package ar.edu.grupoesfera.cursospring.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.modelo.Busqueda;

@Controller
public class BusquedaController {
	
	@RequestMapping(path="/busqueda")
	public ModelAndView search(HttpServletRequest request){
		
		ModelMap search = new ModelMap();
		Busqueda busqueda = new Busqueda();
		search.addAttribute(busqueda);		
		
		return new ModelAndView("busqueda", search);
	}
	
	@RequestMapping(path="/resultadoBusqueda", method = RequestMethod.POST)
	public ModelAndView busquedaRol(@ModelAttribute("busqueda") Busqueda busqueda){ 
		
		ModelMap busquedaRol = new ModelMap();
		busquedaRol.put("rol", busqueda.getRol());
		
		return new ModelAndView("busqueda", busquedaRol);
	}
	
}
