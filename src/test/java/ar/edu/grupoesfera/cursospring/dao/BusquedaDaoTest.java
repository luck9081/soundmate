package ar.edu.grupoesfera.cursospring.dao;

import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.SpringTest;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public class BusquedaDaoTest extends SpringTest {
	
	@Inject
	BusquedaDAOService busquedaDaoService;
	
	@Test
	@Rollback @Transactional
	public void testBuscarUsuariosPorInstrumentoYUbicacion(){
		
		Usuario usuario = new Usuario();
		
		usuario.setIdusuario(1);
		usuario.setNombre("username");
		usuario.setPass("hola");
		usuario.setEmail("mail@user.com");
		usuario.setInstrumento("guitarra");
		usuario.setLocalidad("Moron");
		usuario.setPartido("Ituzaingo");
		usuario.setProvincia("Salta");
		usuario.setImagen("img");
		usuario.setInfluencias("banda");
		
		getSession().save(usuario);
		
		Usuario otroUsuario = new Usuario();
		
		otroUsuario.setIdusuario(1);
		otroUsuario.setNombre("username2");
		otroUsuario.setPass("holaasdasd");
		otroUsuario.setEmail("mail@use2r.com");
		otroUsuario.setInstrumento("bajo");
		otroUsuario.setLocalidad("San Justo");
		otroUsuario.setPartido("La Matanza");
		otroUsuario.setProvincia("Buenos Aires");
		otroUsuario.setImagen("img");
		otroUsuario.setInfluencias("banda3");
		
		getSession().save(otroUsuario);
		
		String nombreUsuario=usuario.getNombre();
		
		
		
		Busqueda busqueda = new Busqueda();
		busqueda.setInstrumento("bajo");
		busqueda.setLocalidad("San Justo");
		busqueda.setPartido("La Matanza");
		busqueda.setProvincia("Buenos Aires");
		
		List<Usuario> listaUsuario;
		
		listaUsuario=busquedaDaoService.buscarUsuariosPorInstrumentoYUbicacion(busqueda, nombreUsuario);
		
		assertThat(listaUsuario).isNotEmpty();
		assertThat(listaUsuario).hasSize(1);
	}

}