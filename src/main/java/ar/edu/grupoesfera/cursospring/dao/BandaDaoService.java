package ar.edu.grupoesfera.cursospring.dao;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface BandaDaoService {

	public void crearNuevaBanda (Banda banda);
	public Banda consultarBandas(String nombre);
}
