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
		
		return (Usuario)sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombre",nombreUsuario))
				.uniqueResult();
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
	
	@Override
	public Usuario editarPerfil (Usuario usuarioEditado,String nombreUsuario){
		
		Usuario usuario = new Usuario();
		
		if(usuarioEditado.getNombre().equals(nombreUsuario)){
			usuario = (Usuario)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(
							Restrictions.eq("nombre",nombreUsuario)
						)
					.uniqueResult();
			
			usuario = (Usuario)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(Restrictions.eq("nombre",nombreUsuario))
					.uniqueResult();
			
			usuario.setNombre(usuarioEditado.getNombre());
			usuario.setPass(usuarioEditado.getPass());
			usuario.setEmail(usuarioEditado.getEmail());
			usuario.setInstrumento(usuarioEditado.getInstrumento());
			usuario.setLocalidad(usuarioEditado.getLocalidad());
			usuario.setPartido(usuarioEditado.getPartido());
			usuario.setProvincia(usuarioEditado.getProvincia());
			usuario.setInfluencias(usuarioEditado.getInfluencias());
			usuario.setImagen(usuario.getImagen());
			
			sessionFactory.getCurrentSession().update("Usuario", usuario);
			
			return usuario;
		}
		
		else{
			usuario = (Usuario)sessionFactory.getCurrentSession()
					.createCriteria(Usuario.class)
					.add(
							Restrictions.or(
									Restrictions.eq("nombre",usuarioEditado.getNombre()),
									Restrictions.eq("email",usuarioEditado.getEmail())
							)
						)
					.uniqueResult();
			
			if (usuario.equals(null)){
				
				usuario = (Usuario)sessionFactory.getCurrentSession()
						.createCriteria(Usuario.class)
						.add(Restrictions.eq("nombre",nombreUsuario))
						.uniqueResult();
				
				usuario.setNombre(usuarioEditado.getNombre());
				usuario.setPass(usuarioEditado.getPass());
				usuario.setEmail(usuarioEditado.getEmail());
				usuario.setInstrumento(usuarioEditado.getInstrumento());
				usuario.setLocalidad(usuarioEditado.getLocalidad());
				usuario.setPartido(usuarioEditado.getPartido());
				usuario.setProvincia(usuarioEditado.getProvincia());
				usuario.setInfluencias(usuarioEditado.getInfluencias());
				usuario.setImagen(usuario.getImagen());
				
				sessionFactory.getCurrentSession().update("Usuario", usuario);
				
				return usuario;
				
			}
			else{
				usuario = new Usuario();	// Si existe un usuario con el mismo nombre/email que al que yo lo quiero cambiar (que no sea mi actual usuario), devuelvo usuario vacio.
				return usuario;
				
			}
			
		}
		
	}
	
}
