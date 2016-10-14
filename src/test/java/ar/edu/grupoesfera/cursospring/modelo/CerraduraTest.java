package ar.edu.grupoesfera.cursospring.modelo;

import org.junit.Assert;
import org.junit.Test;

public class CerraduraTest {
	
	@Test
	public void IngresarClaveCorrectaDeberiaAbrirLaCerradura(){
	
		Cerradura miCerradura1 = new Cerradura();
		
		Boolean abrir = miCerradura1.abrir(1);
		
		Assert.assertTrue(abrir);
	
		
		
	}
	
	@Test
	public void IngresarClaveIncorrectaDeberiaCerrarLaCerradura(){
	
		Cerradura miCerradura2 = new Cerradura();
		
		Boolean abrir = miCerradura2.abrir(213);
		
		Assert.assertTrue(abrir);		
		
	}
	
	@Test
	public void IngresarMasDeTresVecesCodigoIncorrectoDeberiaBloquearCerradura(){
		
		Cerradura miCerradura3 = new Cerradura();
		
		 miCerradura3.abrir(2);
		  miCerradura3.abrir(4);
		  miCerradura3.abrir(5);
		  
		  Boolean bloquear=miCerradura3.contar();
		 
		 Assert.assertTrue(bloquear);
	}
	
}
