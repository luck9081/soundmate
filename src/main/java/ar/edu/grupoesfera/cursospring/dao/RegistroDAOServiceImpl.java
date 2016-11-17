package ar.edu.grupoesfera.cursospring.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;

@Service
@Transactional
public class RegistroDAOServiceImpl implements RegistroDAOService {
	
	@Inject
	protected SessionFactory sessionFactory;
	
	@Override
	public void registrarUsuario(Usuario usuario){
		sessionFactory.getCurrentSession().save(usuario);
	}

}
