package ar.edu.grupoesfera.cursospring.modelo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.context.annotation.Scope;

@Entity
@Scope("session")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long idusuario;	
	
	@Column
	private String nombre;
	
	@Column
	private String pass;
	
	@Column
	private String email;
	
	@Column
	private String instrumento;
	
	@Column
	private String localidad;
	
	@Column
	private String partido;
	
	@Column
	private String provincia;
	
	@Column
	private String influencias;
	
	@Column
	private String imagen;
	
	
	@ManyToOne
	@JoinColumn(name="bandaFK")
	@Cascade(value = CascadeType.ALL)
	private Banda banda;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "id.usuario")
	@Cascade(value = CascadeType.REMOVE)
	private Set<UsuarioEsAmigo> usuario_amigos = new HashSet<UsuarioEsAmigo>();
	

	
	

	public Set<UsuarioEsAmigo> getUsuario_amigos() {
		return usuario_amigos;
	}
	
	
	
	public void setUsuario_amigos(Set<UsuarioEsAmigo> usuario_amigos) {
		this.usuario_amigos = usuario_amigos;
	}



	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getInfluencias() {
		return influencias;
	}
	public void setInfluencias(String influencias) {
		this.influencias = influencias;
	}
	public Banda getBanda() {
		return banda;
	}
	public void setBanda(Banda banda) {
		this.banda = banda;
	}
	public long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(long idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return localidad;
	}	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}




	
}
