package ar.edu.grupoesfera.cursospring.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.modelo.UsuarioAmigoPk;
import ar.edu.grupoesfera.cursospring.modelo.UsuarioEsAmigo;

@Service
@Transactional
public class AmigoDaoServiceImpl implements AmigoDaoService {
	
	@Inject
    private SessionFactory sessionFactory;
	
	public void agregarAListaDeAmigos(long idusuario,long idamigo){
		
		
		UsuarioEsAmigo usuarioEsAmigo = new UsuarioEsAmigo();

		
		Usuario usuario =  (Usuario)sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("idusuario", idusuario))
				.uniqueResult();
		
		Usuario amigo =  (Usuario)sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("idusuario", idamigo))
				.uniqueResult();
		

		
		usuarioEsAmigo.setUsuario(usuario);
		usuarioEsAmigo.setAmigo(amigo);
		usuarioEsAmigo.setEstado("Solicitud no aceptada");
		
		usuario.getUsuario_amigos().add(usuarioEsAmigo);
		
		
		sessionFactory.getCurrentSession().save(usuarioEsAmigo);
		
		sessionFactory.getCurrentSession().update(usuario);

	}

	
}
