package ar.edu.grupoesfera.cursospring.dao;
import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.SpringTest;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

import static org.assertj.core.api.Assertions.*;



public class BandaDaoTest extends SpringTest {
	
	@Inject
	 BandaDaoService bandaDaoService;
	
	@Test @Rollback @Transactional
	public void testConsultarBandaDevuelveBandaExistente(){
		
		bandaDaoService.setSessionFactoryMock(sessionFactory);
		
		Banda banda = new Banda();
		
		banda.setGenero("rock");
		banda.setNombre("Programadores");
		banda.setId(1);
		
		getSession().save(banda);
		
		
		Usuario usuario = new Usuario();
		
		usuario.setIdusuario(1);
		usuario.setNombre("username");
		usuario.setPass("hola");
		usuario.setEmail("mail@user.com");
		usuario.setInstrumento("bajo");
		usuario.setLocalidad("San Justo");
		usuario.setPartido("La Matanza");
		usuario.setProvincia("Buenos Aires");
		usuario.setImagen("img");
		usuario.setInfluencias("banda");
		usuario.setBanda(banda);
		
		getSession().save(usuario);
		
		
		
		
		getSession().save(banda);
		
		Banda bandaResultado = bandaDaoService.consultarBandas("username");
		
		assertThat(banda).isEqualTo(bandaResultado);
	}
	

}
