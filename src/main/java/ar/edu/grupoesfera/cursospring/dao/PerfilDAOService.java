package ar.edu.grupoesfera.cursospring.dao;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface PerfilDAOService {
	public Usuario obtenerUsuarioPorNombre (String nombreUsuario);
}