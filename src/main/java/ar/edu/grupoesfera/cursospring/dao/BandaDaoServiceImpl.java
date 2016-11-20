package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class BandaDaoServiceImpl implements BandaDaoService {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public void crearNuevaBanda (Banda banda){
		
		final Session s = sessionFactory.openSession();
		
		s.save(banda);
		
		
		
		return;
	}
	
	
	@Override
	public Banda consultarBandas (String nombre){
		
		
		Usuario usuario =  (Usuario)sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombre", nombre))
				.uniqueResult();
		
		return usuario.getBanda();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> consultarMiembros (Banda banda){
		
		
		List<Usuario> miembros = sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("banda", banda))
				.list();
		
		return miembros;
	}

}
