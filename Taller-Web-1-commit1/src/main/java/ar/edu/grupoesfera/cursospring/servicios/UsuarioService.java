package ar.edu.grupoesfera.cursospring.servicios;

import org.springframework.ui.ModelMap;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface UsuarioService {
	
	 ModelMap registrarUsuario(Usuario usuario);
	 ModelMap ingresarUsuario(Usuario usuario);

}
