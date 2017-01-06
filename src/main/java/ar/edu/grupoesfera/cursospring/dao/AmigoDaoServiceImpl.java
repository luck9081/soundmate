package ar.edu.grupoesfera.cursospring.dao;

import java.util.Iterator;

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
		UsuarioEsAmigo usuarioEsAmigo2= new UsuarioEsAmigo();

		
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
		usuarioEsAmigo.setEstado(0);//0=solicitud enviada no aceptada //1=solicitud aceptada o amistad concretada
		
		usuario.getUsuario_amigos().add(usuarioEsAmigo);
		
		usuarioEsAmigo2.setUsuario(amigo);
		usuarioEsAmigo2.setAmigo(usuario);
		usuarioEsAmigo2.setEstado(-1);//-1=solicitud recibida no aceptada //1=solicitud aceptada o amistad concretada
		
		amigo.getUsuario_amigos().add(usuarioEsAmigo2);
		
		sessionFactory.getCurrentSession().save(usuarioEsAmigo);
		sessionFactory.getCurrentSession().save(usuarioEsAmigo2);

		
		
		
		
		//sessionFactory.getCurrentSession().update(usuario);

	}
	
	public void eliminarAmigos(Usuario usuarioLogueado, Usuario amigo){
		//recorro la lista del usuario logueado
		for(Object it : usuarioLogueado.getUsuario_amigos().toArray()) { /* Create a copy */

		    UsuarioEsAmigo element = (UsuarioEsAmigo)it;
		    
			    if(element.getAmigo().getIdusuario() == amigo.getIdusuario()){
			    	
			       usuarioLogueado.getUsuario_amigos().remove(element);
				   sessionFactory.getCurrentSession().delete(element);
			       
			    }
		}
		//recorro la lista del amigo
		for(Object it : amigo.getUsuario_amigos().toArray()) { /* Create a copy */

		    UsuarioEsAmigo element = (UsuarioEsAmigo)it;
		    
			    if(element.getAmigo().getIdusuario() == usuarioLogueado.getIdusuario()){
			    	
				    amigo.getUsuario_amigos().remove(element);
			    	sessionFactory.getCurrentSession().delete(element);
			       
			    }
			    


		}


	}//eliminarAmigos metodo

	public void aceptarSolicitudDeAmistad(Usuario usuarioLogueado,	Usuario amigo) {
		
		//recorro la lista del usuario logueado
		for(Object it : usuarioLogueado.getUsuario_amigos().toArray()) { /* Create a copy */

		    UsuarioEsAmigo element = (UsuarioEsAmigo)it;
		    
			    if(element.getAmigo().getIdusuario() == amigo.getIdusuario()){
			    	
			       element.setEstado(1);//1=solicitud aceptada o amistad concretada
				   sessionFactory.getCurrentSession().update(element);
			       
			    }
		}
		//recorro la lista del amigo
		for(Object it : amigo.getUsuario_amigos().toArray()) { /* Create a copy */

		    UsuarioEsAmigo element = (UsuarioEsAmigo)it;
		    
			    if(element.getAmigo().getIdusuario() == usuarioLogueado.getIdusuario()){
			    	
			       element.setEstado(1);//1=solicitud aceptada o amistad concretada
				   sessionFactory.getCurrentSession().update(element);
			       
			    }
			    


		}
		
	}



}//class
