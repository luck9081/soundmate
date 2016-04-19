package ar.unlam.TrabajosPracticos;
import java.lang.Math;
//Clase
public class Circulo {
	
	private Double radio;
	
	
//Constructor	
	public Circulo (Double radio) {
		
		this.radio = radio;
		
	
	}
	
	public Double mostrarRadio () {
		
		return this.radio;
		
	
	}
//Metodo
	public Double calcularPerimetro (){
		
		return 2*radio*Math.PI;
		
	}
	
	
}
