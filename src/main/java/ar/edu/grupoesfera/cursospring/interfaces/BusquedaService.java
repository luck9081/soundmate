package ar.edu.grupoesfera.cursospring.interfaces;

import java.util.List;
import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface BusquedaService {
	List<Usuario> buscarUsuariosPorInstrumentoYUbicacion(Busqueda busqueda);
	
	List<Usuario> buscarUsuariosPorNombreOEmail(String nombre, String email);
}
