package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class PerfilDAOServiceImpl implements PerfilDAOService {
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Usuario obtenerUsuarioPorNombre (String nombreUsuario){
		
		@SuppressWarnings("rawtypes")
		List resultadosQuery = sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombre",nombreUsuario)).list();
		
		Usuario miUsuario = new Usuario();
		
		for(Object item : resultadosQuery){
			miUsuario = (Usuario)item;
		}
		
		return miUsuario;
	}
	

	@Override
	public Banda obtenerBandaPorNombre (String nombreBanda){
		
		@SuppressWarnings("rawtypes")
		List resultadosQuery = sessionFactory.getCurrentSession()
				.createCriteria(Banda.class)
				.add(Restrictions.eq("nombre",nombreBanda)).list();
		
		Banda miBanda = new Banda();
		
		for(Object item : resultadosQuery){
			miBanda = (Banda)item;
		}
		
		return miBanda;
	}
}
