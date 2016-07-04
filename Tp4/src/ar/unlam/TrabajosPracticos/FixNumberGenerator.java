package ar.unlam.TrabajosPracticos;

public class FixNumberGenerator implements NumberGenerator {
	private Integer number;
	
public FixNumberGenerator(Integer number){
	this.number=number;
}
	
	public Integer generate(){
		return number;
		
	}
}
