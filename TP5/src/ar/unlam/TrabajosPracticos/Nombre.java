package ar.unlam.TrabajosPracticos;

public class Nombre implements Comparable <Nombre> {
	private String nombre;
	private Integer edad;
	

	public Nombre(String otroNombre, Integer otraEdad){
		this.nombre=otroNombre;
		this.edad=otraEdad;
	}
	
	
	public Integer getEdad(){
		return edad;
	}
	
	public String getNombre(){
		
		return nombre;
	}




	@Override
	public int compareTo(Nombre otroNombre) {//orden alfabetico
		// TODO Auto-generated method stub
		return this.nombre.compareTo(otroNombre.getNombre());
	}
	
	@Override
	public String toString(){
		
		return "Nombre:"+ nombre + " Edad:"+ edad ;
	}
}
