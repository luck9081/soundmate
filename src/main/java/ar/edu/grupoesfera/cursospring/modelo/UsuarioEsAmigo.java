package ar.edu.grupoesfera.cursospring.modelo;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "usuario_es_amigo")
@AssociationOverrides({
	@AssociationOverride(name = "id.usuario",joinColumns = @JoinColumn(name="idusuario")),
	@AssociationOverride(name = "id.amigo",joinColumns = @JoinColumn(name = "idamigo"))
})
public class UsuarioEsAmigo {
	
	@EmbeddedId
	private UsuarioAmigoPk id = new UsuarioAmigoPk();
	
	@Column
	private String estado;
	

	public UsuarioAmigoPk getId() {
		return id;
	}

	public void setId(UsuarioAmigoPk id) {
		this.id = id;
	}
	
	public Usuario getUsuario(){
		return id.getUsuario();
	}
	
	public void setUsuario(Usuario usuario){
		id.setUsuario(usuario);
	}
	
	public Usuario getAmigo(){
		return id.getAmigo();
	}
	
	public void setAmigo(Usuario amigo){
		id.setAmigo(amigo);
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	


}
