package ar.unlam.TrabajosPracticos;

import java.util.Comparator;
import java.util.LinkedList;

public class Bar implements Comparator <Nombre> {
	
	private static LinkedList<Nombre> lista;
	
	public  Bar(LinkedList<Nombre> otraLista){//Abrir bar
		
		lista = otraLista;
	}
	
	
	public static LinkedList<Nombre> getLista(){
		
		return lista;
	}
	
	@Override
	public int compare(Nombre unNombre, Nombre otroNombre) {/*Orden por edad*/
		// TODO Auto-generated method stub
		return unNombre.getEdad().compareTo(otroNombre.getEdad());
	}







	

}
