package ar.unlam.TrabajosPracticos;

import static org.junit.Assert.assertEquals;

import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;


public class NombreTest {

	@Test
	public void queLaListaSeCreo(){
		
		Nombre n1 = new Nombre("pepe",30);
		Nombre n2 = new Nombre("montoto",23);
		Nombre n3 = new Nombre("chipereli",24);

		Bar bar = new Bar();
		
		bar.setLista(n1);
		bar.setLista(n2);
		bar.setLista(n3);
		
		TreeSet<Nombre> valoresperado = new TreeSet<Nombre>();
		
		Nombre n4 = new Nombre("pepe",30);
		Nombre n5 = new Nombre("montoto",3);
		Nombre n6 = new Nombre("chipereli",24);
		
		valoresperado.add(n4);
		valoresperado.add(n5);
		valoresperado.add(n6);
		
		Assert.assertEquals(valoresperado,bar.getLista());
		


		
	}
	
	@Test
	public void queLaListaSeOrdenoNaturalmente(){//Por nombre
		
		Nombre n1 = new Nombre("zala",15);
		Nombre n2 = new Nombre("alberto",35);
		Nombre n3 = new Nombre("emiliano",55);
		
		Bar bar = new Bar();
		
		bar.setLista(n1);
		bar.setLista(n2);
		bar.setLista(n3);
		
		
	
		
		Assert.assertEquals("alberto",bar.getLista().first().getNombre());
			
	}
	
	@Test
	public void queLaListaSeOrdenePorEdad(){//
		
		Nombre n1 = new Nombre("zala",15);
		Nombre n2 = new Nombre("Cristobal",20);
		Nombre n3 = new Nombre("Alberto",5);
	
		porEdadComparator comparator = new porEdadComparator();//creo una lista a parte
		TreeSet<Nombre> lista = new TreeSet<Nombre>(comparator);//a esta lista le paso un comparator 
		lista.add(n1);
		lista.add(n2);
		lista.add(n3);
		
		Bar bar = new Bar ();//creo un bar
		
		bar.setListaEntera(lista);//le paso la lista comparada 
	
	
		assertEquals("Alberto", bar.getLista().first().getNombre());
		assertEquals("Cristobal", bar.getLista().last().getNombre());
			
	}
	
}
