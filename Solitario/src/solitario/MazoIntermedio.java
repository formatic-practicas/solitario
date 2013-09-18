package solitario;

public class MazoIntermedio extends Mazo {
	@Override
	public String toString() {
		if (estaVacio()) {
			return "[]";
		}
		return "" + getNumCartas() + " [" + getUltimaCarta().toString() + "]";
	}

	@Override
	public boolean puedoAgregarCarta(Carta carta) {
		if (estaVacio()) {
			if (carta.getNumero() == 13) {
				return true;
			}
		} else {
			if (carta.getColor() != getUltimaCarta().getColor()) {
				if (carta.getNumero() == getUltimaCarta().getNumero() - 1) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean agregarCarta(Carta carta) {
		if (puedoAgregarCarta(carta)) {
			return super.agregarCarta(carta);
		}
		return false;
	}
}
