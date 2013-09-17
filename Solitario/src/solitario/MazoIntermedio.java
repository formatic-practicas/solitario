package solitario;



public class MazoIntermedio extends Mazo {
	@Override
	public String toString() {
		if(estaVacio()){
			return "[]";
		}
		return ""+getNumCartas()+ " ["+ getUltimaCarta().toString()+"]";
	}
	@Override
	public boolean agregarCarta(Carta carta) {
		if (estaVacio()) {
			if (carta.getNumero() == 13) {
				return super.agregarCarta(carta);
			}
		} else {
			if (carta.getColor() != getUltimaCarta().getColor()) {
				if (carta.getNumero() == getUltimaCarta().getNumero() - 1) {
					return super.agregarCarta(carta);
				}
			}
		}
		return false;
	}
}
