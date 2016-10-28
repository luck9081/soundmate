package ar.unlam.TrabajosPracticos;

import java.util.Comparator;

public class porEdadComparator implements Comparator<Nombre> {

	@Override
	public int compare(Nombre unNombre, Nombre otroNombre) {/*Orden por edad*/
		// TODO Auto-generated method stub
		return unNombre.getEdad().compareTo(otroNombre.getEdad());
	}

}
