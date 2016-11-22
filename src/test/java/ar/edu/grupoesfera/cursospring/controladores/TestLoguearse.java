package ar.edu.grupoesfera.cursospring.controladores;

import org.junit.Test;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public class TestLoguearse {

	
	@Test
	public void testUsuarioYContraseniaCorrectosDebenLlevarAPerfil(){
		
		RegistroController controladorRegistro = new RegistroController();
		
		Usuario usuarioNuevo = new Usuario();
		
		usuarioNuevo.setNombre("pablo");
		usuarioNuevo.setPass("pass");
		
		
		
	}
}
