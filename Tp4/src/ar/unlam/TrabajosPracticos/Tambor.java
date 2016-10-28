package ar.unlam.TrabajosPracticos;

public class Tambor {
	private Integer posicion;


	
	public Tambor (NumberGenerator generator){
	this.posicion=generator.generate();
	
	}
	
	public Integer getPosicion(){
		
		return this.posicion;
	}

	
	public void girar(){
		RandomNumberGenerator giro = new RandomNumberGenerator();
		this.posicion=giro.generate();
	}
	
}


