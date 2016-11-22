package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import ar.edu.grupoesfera.cursospring.modelo.Banda;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface BandaDaoService {

	public void crearNuevaBanda (Banda banda,String nombreUsuario);
	
	public Banda consultarBandas(String nombre);
	
	public List<Usuario> consultarMiembros(Banda banda);
	
	public void aniadirABanda(String nombreUsuario, Banda banda);
	
}
