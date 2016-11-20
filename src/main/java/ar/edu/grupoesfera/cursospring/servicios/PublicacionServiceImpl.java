package ar.edu.grupoesfera.cursospring.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.dao.PublicacionDao;
import ar.edu.grupoesfera.cursospring.interfaces.PublicacionService;
import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Publicacion;

@Service
@Transactional
public class PublicacionServiceImpl implements PublicacionService {
	
	@Inject PublicacionDao publicacionDao;
	
	@Override
	public void crearPublicacion (Publicacion publicacion, String username){
		
		publicacionDao.crearPublicacion(publicacion, username);
		
	}
	
	@Override
	public List<Publicacion> mostrarPublicaciones (String nombreBanda){
		
		List<Publicacion> publicaciones = publicacionDao.mostrarPublicaciones(nombreBanda);
		
		return publicaciones;
	}
	
	
	@Override
	public void crearPublicacionUsuario ( Publicacion publicacion, String username){
		
		publicacionDao.crearPublicacion(publicacion, username);
	}
	
	@Override
	public List<Publicacion> mostrarPublicacionesUsuario (String username){
		
		List<Publicacion> publicacionesUser = publicacionDao.mostrarPublicacionesUsuario(username);
		
		return publicacionesUser;
	}
}
