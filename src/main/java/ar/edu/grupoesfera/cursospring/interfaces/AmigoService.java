package ar.edu.grupoesfera.cursospring.interfaces;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface  AmigoService {
	
	public void agregarAListaDeAmigos(long idusuario,long idamigo);
	public Integer buscarAmigo(Usuario usuarioLogueado, long idamigo );

}
