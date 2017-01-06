package ar.edu.grupoesfera.cursospring.interfaces;

import java.util.List;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.modelo.UsuarioEsAmigo;

public interface  AmigoService {
	
	public void agregarAListaDeAmigos(long idusuario,long idamigo);
	public Integer buscarAmigo(Usuario usuarioLogueado, long idamigo );
	public void eliminarAmigos(Usuario usuarioLogueado, Usuario amigo);
	public void aceptarSolicitudDeAmistad(Usuario miUsuarioLogueado, Usuario amigo);
	public List<UsuarioEsAmigo> buscarSolicitudesDeAmistad(Usuario miUsuarioLogueado);


}
