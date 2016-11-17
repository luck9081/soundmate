package ar.edu.grupoesfera.cursospring.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Banda;

@Service
@Transactional
public class RegistrarBandaDaoServiceImpl implements RegistrarBandaDaoService {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public void crearNuevaBanda (Banda banda){
		
		final Session s = sessionFactory.openSession();
		
		s.save(banda);
		
		
		
		return;
	}

}
