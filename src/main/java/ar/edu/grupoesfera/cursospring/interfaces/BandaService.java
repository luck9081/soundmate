package ar.edu.grupoesfera.cursospring.interfaces;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface BandaService {
	
	public void registrarBanda(Banda banda);
	public Banda consultarBandas(String nombre);
}
