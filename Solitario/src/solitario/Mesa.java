package solitario;

public class Mesa {
	public Mesa(){
		mazos= new Mazo[TipoMazo.values().length];
		mazos[TipoMazo.BARAJA.ordinal()] = new Baraja();
		mazos[TipoMazo.DESCARTE.ordinal()] = new Descarte();
		
		mazos[TipoMazo.FINAL1.ordinal()] = new MazoFinal();
		mazos[TipoMazo.FINAL2.ordinal()] = new MazoFinal();
		mazos[TipoMazo.FINAL3.ordinal()] = new MazoFinal();
		mazos[TipoMazo.FINAL4.ordinal()] = new MazoFinal();

		mazos[TipoMazo.INTERMEDIO1.ordinal()] = new MazoIntermedio();
		mazos[TipoMazo.INTERMEDIO1.ordinal()].agregarCarta(
				mazos[TipoMazo.BARAJA.ordinal()].extraerCarta()
				, true
		); 
		mazos[TipoMazo.INTERMEDIO2.ordinal()] = new MazoIntermedio();
		mazos[TipoMazo.INTERMEDIO2.ordinal()].agregarCarta(
				mazos[TipoMazo.BARAJA.ordinal()].extraerCarta()
				, true
		);
 		mazos[TipoMazo.INTERMEDIO3.ordinal()] = new MazoIntermedio();
		mazos[TipoMazo.INTERMEDIO3.ordinal()].agregarCarta(
				mazos[TipoMazo.BARAJA.ordinal()].extraerCarta()
				, true
		);
		mazos[TipoMazo.INTERMEDIO4.ordinal()] = new MazoIntermedio();
		mazos[TipoMazo.INTERMEDIO4.ordinal()].agregarCarta(
				mazos[TipoMazo.BARAJA.ordinal()].extraerCarta()
				, true
		); 
	}
	@Override
	public String toString() {
		String ret = "";
		for(int n= 0; n< TipoMazo.values().length; n++){
			ret+= n + ": "+ mazos[n].toString();
			ret+= "\n";
		}
		return ret;
	}
	boolean elegirMazoDesde(TipoMazo tipoMazo){
		mazoDesde = tipoMazo;
		if(mazoDesde == TipoMazo.BARAJA){
			Mazo baraja = mazos[mazoDesde.ordinal()];
			if(baraja.estaVacio()){
				moverDescarteABaraja();
			}
			int numCartas = baraja.getNumCartas();
			if(numCartas > 3){
				numCartas = 3;
			}
			for(int n=0; n<numCartas; n++){
				Carta c = baraja.extraerCarta();
				mazos[TipoMazo.DESCARTE.ordinal()].agregarCarta(c);
			}
			return false;
		}
		return !(mazos[tipoMazo.ordinal()].estaVacio());
			
	}
	public void sacarDeBarajaADescarte(){
		int maxCartas = 3;
		int numCartas = mazos[TipoMazo.BARAJA.ordinal()].getNumCartas();
		if(numCartas < maxCartas){
			maxCartas = numCartas;
		}
		if(maxCartas == 0){
			moverDescarteABaraja();
		}else{
			for(int n=0; n<maxCartas; n++){
				Carta c = mazos[TipoMazo.BARAJA.ordinal()].extraerCarta();
				mazos[TipoMazo.DESCARTE.ordinal()].agregarCarta(c);
			}
		}
		
	}
	private void moverDescarteABaraja() {
		while(!mazos[TipoMazo.DESCARTE.ordinal()].estaVacio()){
			Carta c = mazos[TipoMazo.DESCARTE.ordinal()].extraerCarta();
			mazos[TipoMazo.BARAJA.ordinal()].agregarCarta(c);
		}
	}
	// TODO sacar de aqui la accion y dejar solo la condición
	boolean elegirMazoHasta(TipoMazo tipoMazo){
		mazoHasta= tipoMazo;
		if(mazoHasta == TipoMazo.BARAJA || mazoHasta == TipoMazo.DESCARTE){
			return false;
		}
		Carta carta = mazos[mazoDesde.ordinal()].getUltimaCarta();
		if(mazos[mazoHasta.ordinal()].puedoAgregarCarta(carta)){
			mazos[mazoDesde.ordinal()].extraerCarta();
			mazos[mazoHasta.ordinal()].agregarCarta(carta);
			return true;
		}
		return false;
	}
	TipoMazo mazoDesde, mazoHasta;
	Mazo[] mazos;
	
	
}
