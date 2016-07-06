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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nombre other = (Nombre) obj;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
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
