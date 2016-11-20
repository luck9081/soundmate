package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.edu.grupoesfera.cursospring.modelo.Publicacion;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
public class PublicacionDaoImpl implements PublicacionDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public void crearPublicacion (Publicacion publicacion, String username){
		
		Usuario usuario =  (Usuario)sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombre", username))
				.uniqueResult();
		
		publicacion.setUsuario(usuario);
		publicacion.setBanda(usuario.getBanda());
		
		final Session s = sessionFactory.openSession();
		
		s.save(publicacion);		
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacion> mostrarPublicaciones (String nombreBanda){
		
		
		List<Publicacion> publicaciones = sessionFactory.getCurrentSession()
			.createCriteria(Publicacion.class)
			.createAlias("banda", "b")
			.add(Restrictions.eq("b.nombre", nombreBanda ))
			.list();

		
		return publicaciones;
	}
	
}
