package ar.edu.grupoesfera.cursospring.servicios;

import org.springframework.ui.ModelMap;

import ar.edu.grupoesfera.cursospring.modelo.Busqueda;

public interface BusquedaService {
	ModelMap buscarUsuarios(Busqueda busqueda);
}
