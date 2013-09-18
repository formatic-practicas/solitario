package solitario;



public class Descarte extends Mazo {
	@Override
	public boolean puedoAgregarCarta(Carta carta) {
		return false;
	}

	@Override
	public String toString() {
		if(estaVacio()){
			return "{}";
		}
		return "{"+ getUltimaCarta().toString()+"}";
	}
}
