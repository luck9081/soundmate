package ar.unlam.TrabajosPracticos;

public class TragaMonedas {

	private FixNumberGenerator  generator = new FixNumberGenerator(1);
	private Tambor tambor1;
	private Tambor tambor2;
	private Tambor tambor3;
	
	public TragaMonedas(){
		
		this.tambor1 = new Tambor(generator);
		this.tambor2 = new Tambor(generator);
		this.tambor3 = new Tambor(generator);
	}
	
	public void activar (){
		
		this.tambor1.girar();
		this.tambor2.girar();
		this.tambor3.girar();
	}
	
	public Boolean entregaPremio(){
	if(tambor1.getPosicion()==tambor2.getPosicion() && tambor2.getPosicion()==tambor3.getPosicion()){
		return true;
	}
	return false;

	}
/*Metodo delegado de tambor*/
	public Integer getPosicion() {
		return tambor1.getPosicion();
	}

	}
