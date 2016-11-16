package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
