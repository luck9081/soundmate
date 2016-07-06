package ar.unlam.TrabajosPracticos;



import java.util.TreeSet;

public class Bar  {
	
	private TreeSet<Nombre> lista;

	
	public  Bar(){//Abrir bar
		
		this.lista = new TreeSet<Nombre>();
	}
	
	public TreeSet<Nombre> getLista(){
		
		return lista;
	}

	
	public void setLista(Nombre nombre){
		
		lista.add(nombre);
	}


	public void setListaEntera(TreeSet<Nombre> listaentera){
		
		this.lista=listaentera;
	}






	

}
