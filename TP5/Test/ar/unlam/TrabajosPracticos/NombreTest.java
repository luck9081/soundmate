package ar.unlam.TrabajosPracticos;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.Test;

public class NombreTest {

	@Test
	public void queLaListaSeCreo(){
		
		Nombre n1 = new Nombre("pepe",30);
		Nombre n2 = new Nombre("montoto",23);
		Nombre n3 = new Nombre("chipereli",24);
		
		LinkedList<Nombre> lista = new LinkedList<Nombre>();
		
		lista.add(n1);
		lista.add(n2);
		lista.add(n3);
		
		Bar bar = new Bar(lista);
		
		System.out.println(Bar.getLista());
		
	}
	
	@Test
	public void queLaListaSeOrdenoPorEdad(){
		
		Nombre n1 = new Nombre("eduardo",15);
		Nombre n2 = new Nombre("anabel",49);
		Nombre n3 = new Nombre("carlos",24);
		
		LinkedList<Nombre> lista = new LinkedList<Nombre>();
		
		lista.add(n1);
		lista.add(n2);
		lista.add(n3);
		
		Bar bar = new Bar(lista);
		Collections.sort(lista, new Bar(lista));
		System.out.println(Bar.getLista());
		
	}
	
	@Test
	public void queLaListaSeOrdenoAlfabeticamente(){
		
		Nombre n1 = new Nombre("b",30);
		Nombre n2 = new Nombre("z",23);
		Nombre n3 = new Nombre("a",24);
		
		LinkedList<Nombre> lista = new LinkedList<Nombre>();
		
		lista.add(n1);
		lista.add(n2);
		lista.add(n3);
		
	
		Collections.sort(lista);
		System.out.println(lista);
		
	}
}
