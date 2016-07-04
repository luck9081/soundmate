package ar.unlam.TrabajosPracticos;

public class RandomNumberGenerator implements NumberGenerator {

	
	
	public Integer generate(){
		
		
		return (Integer)(int)Math.floor(Math.random()*(10-1)+1);
		
	}
	

}
