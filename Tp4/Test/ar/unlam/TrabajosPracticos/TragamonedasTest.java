package ar.unlam.TrabajosPracticos;

import org.junit.Assert;
import org.junit.Test;

public class TragamonedasTest{
	
	@Test
	public void QueElTragamonedasSeInicializoEn1(){
	
		TragaMonedas t = new TragaMonedas();
		Integer valoresperado=1;
		
		Assert.assertTrue(t.getPosicion()==valoresperado);
		
	}
	
	@Test
	public void  QueElTamborGeneraUnNumero(){
		
		FixNumberGenerator f = new FixNumberGenerator(2);
		Tambor t= new Tambor(f);
		Integer valoresperado=2;
		
		Assert.assertTrue(t.getPosicion()==valoresperado);
		
		
		
	}
	
	@Test
	public void  QueElTragamonedasEntregaPremio(){
		
		TragaMonedas t= new TragaMonedas(); // Los tres tambores estan en la posicion 1 por ende devuelve premio
		
		Assert.assertTrue(true==t.entregaPremio());
		
		
		
	}
	
	
}