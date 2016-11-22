package ar.edu.grupoesfera.cursospring.dao;
import javax.inject.Inject;


import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.SpringTest;
import static org.assertj.core.api.Assertions.*;



public class BandaDaoTest extends SpringTest {
	
	@Inject
	 BandaDaoService bandaDaoService;
	
	@Rollback @Transactional
	public void testConsultarBanda(){
		
		Banda banda = new Banda();
		
		banda.setGenero("rock");
		banda.setNombre("Programadores");
		banda.setId(1);
		
		getSession().save(banda);
		
		Banda bandaResultado = new Banda();
		
		bandaResultado=bandaDaoService.consultarBandas("Programadores");
		
		assertThat(banda).isEqualTo(bandaResultado);		
	}
	

}
