package ar.edu.grupoesfera.cursospring.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.interfaces.PerfilService;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Controller
@Scope("session")
public class PerfilController {
	
	@Inject
	public PerfilService perfilService;
	
	/* ------ MOSTRAR PERFIL PROPIO ------ */
	
	@RequestMapping("/perfil")
	public ModelAndView perfil(HttpServletRequest request) {
		
		Usuario miUsuario = perfilService.buscarPerfilUsuario((String)request.getSession().getAttribute("username")); // A la busqueda de perfil de usuario le paso el atributo de session (casteado a string).
		
		ModelMap perfil = new ModelMap();
		perfil.addAttribute("usuario",miUsuario);
		
		return new ModelAndView("profile",perfil);
	}
	
	/* ------ BUSCAR PERFIL PUBLICO O EDITAR PERFIL PROPIO ------ */
	
	@RequestMapping("/perfil/{username}")
	public ModelAndView perfilUser(@PathVariable("username") String nombreUsuario,HttpServletRequest request){

		String sesion = (String)request.getSession().getAttribute("username");
		
		ModelMap perfil = new ModelMap();
		
		if(nombreUsuario.equals("editar")){
			Usuario miUsuario = perfilService.buscarPerfilUsuario(sesion);
			
			perfil.addAttribute("usuario",miUsuario);
			perfil.addAttribute("reubicacion","../");
			
			return new ModelAndView("profileEdit",perfil);
		}
		else if(nombreUsuario.equals(sesion)){
			
			return new ModelAndView("redirect:../perfil");
		}
		else{
			Usuario usuarioEncontrado = perfilService.buscarPerfilUsuario(nombreUsuario);
			
			if(usuarioEncontrado.getNombre() == null){
				ModelMap resultado = new ModelMap();
				
				resultado.addAttribute("title","Perfil");
				resultado.addAttribute("titulo","�Ups! No hemos encontrado este usuario.");
				resultado.addAttribute("subtitulo","Probablemente haya dado de baja su cuenta. �Prob� buscar otro!");
				resultado.addAttribute("inputValue","Ir a B�squeda");
				resultado.addAttribute("inputHref","../busqueda");
				resultado.addAttribute("iconClass","fa fa-chevron-left");
				resultado.addAttribute("reubicacion","../");
				
				return new ModelAndView("landing",resultado);
			}
			else{
				perfil.addAttribute("usuario",usuarioEncontrado);
				perfil.addAttribute("reubicacion","../");	// String necesario para que todos los recursos css, js, imagenes y backgrounds tengan su "src" correctamente (a causa del PathVariable)
				
				return new ModelAndView("profile",perfil);
			}
		}
	
	}
	
	/* ------ REDIRIGIR A PERFIL PROPIO ------ */
	
	@RequestMapping("/perfil/")
	public ModelAndView redirigirAPerfil(){
		return new ModelAndView("redirect:../perfil");
	}
	
	/* ------ ACTUALIZACION DE PERFIL PROPIO ------ */
	
	@RequestMapping("/editarPerfil")
	public ModelAndView modificarPerfil(@ModelAttribute("usuario") Usuario usuario,HttpServletRequest request){
		
		usuario.setNombre(usuario.getNombre().toLowerCase());
		usuario.setInstrumento(usuario.getInstrumento().toLowerCase());
		
		Usuario usuarioEditado = perfilService.editarPerfil(usuario,(String)request.getSession().getAttribute("username"));
		
		request.getSession().setAttribute("username", usuarioEditado.getNombre());
		request.getSession().setAttribute("localidad", usuarioEditado.getLocalidad());
		request.getSession().setAttribute("partido", usuarioEditado.getPartido());
		request.getSession().setAttribute("provincia", usuarioEditado.getProvincia());
		
		ModelMap resultado = new ModelMap();
		
		resultado.addAttribute("titulo","�Se ha modificado tu perfil!");
		resultado.addAttribute("subtitulo","Todos tus datos se guardaron satisfactoriamente");
		resultado.addAttribute("inputValue","Ver Mi Perfil");
		resultado.addAttribute("inputHref","perfil");
		resultado.addAttribute("iconClass","fa fa-chevron-right");
		
		return new ModelAndView("landing",resultado);
	}
	
}
