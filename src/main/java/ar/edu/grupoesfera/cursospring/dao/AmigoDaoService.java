package ar.edu.grupoesfera.cursospring.dao;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface AmigoDaoService {
	
	public void agregarAListaDeAmigos(long idusuario,long idamigo);
	public void eliminarAmigos(Usuario usuarioLogueado, Usuario amigo);
	public void aceptarSolicitudDeAmistad(Usuario miUsuarioLogueado, Usuario amigo);


}
