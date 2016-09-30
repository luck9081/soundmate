package ar.edu.grupoesfera.cursospring.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.servicioRegistroDeUsuario;

@Controller
public class RegistroController {


	@RequestMapping("/hola")
	public ModelAndView hola() {

		return new ModelAndView("hola");
	}
}