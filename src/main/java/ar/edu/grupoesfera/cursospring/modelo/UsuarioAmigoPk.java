package ar.edu.grupoesfera.cursospring.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UsuarioAmigoPk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Usuario amigo;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Usuario getAmigo() {
		return amigo;
	}
	public void setAmigo(Usuario amigo) {
		this.amigo = amigo;
	}


}
