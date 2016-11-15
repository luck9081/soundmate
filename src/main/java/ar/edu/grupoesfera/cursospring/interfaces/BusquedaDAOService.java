package ar.edu.grupoesfera.cursospring.interfaces;

import java.util.List;

import ar.edu.grupoesfera.cursospring.modelo.Busqueda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface BusquedaDAOService {
	public List<Usuario> obtenerUsuariosPorInstrumento(Busqueda busqueda);
}
