package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import ar.edu.grupoesfera.cursospring.modelo.Publicacion;

public interface PublicacionDao {
	
	public void crearPublicacion (Publicacion publicacion, String username);
	public List<Publicacion> mostrarPublicaciones (String nombreBanda);
	public void crearPublicacionUsuario (Publicacion publicacion, String username);
	public List<Publicacion> mostrarPublicacionesUsuario (String username);

}
