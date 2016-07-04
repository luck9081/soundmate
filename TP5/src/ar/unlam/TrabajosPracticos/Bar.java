package ar.unlam.TrabajosPracticos;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Bar implements Comparator <Nombre> {
	
	private static TreeSet<Nombre> lista;
	
	public  Bar(SortedSet<Nombre> lista2){//Abrir bar
		
		lista = (TreeSet<Nombre>) lista2;
	}
	
	
	public static TreeSet<Nombre> getLista(){
		
		return lista;
	}
	
	@Override
	public int compare(Nombre unNombre, Nombre otroNombre) {/*Orden por edad*/
		// TODO Auto-generated method stub
		return unNombre.getEdad().compareTo(otroNombre.getEdad());
	}







	

}
