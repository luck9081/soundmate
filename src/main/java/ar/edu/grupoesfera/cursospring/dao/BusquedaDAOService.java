package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface BusquedaDAOService {
	public List<Usuario> obtenerUsuariosPorInstrumentoYUbicacion(Busqueda busqueda);
	
	public List<Usuario> obtenerUsuariosPorNombreOEmail(String nombre, String email);
}
