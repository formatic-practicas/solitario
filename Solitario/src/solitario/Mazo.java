package solitario;

public class Mazo implements PilaDeCartas {

	private static final int MAX_CARTAS = 52;
	private Carta[] cartas;
	private int numCartas;

	public Mazo() {
		cartas = new Carta[MAX_CARTAS];
		numCartas = 0;
	}

	@Override
	public int getNumCartas() {
		return numCartas;
	}

	@Override
	public void barajar() {
		for (int n = 0; n < numCartas; n++) {
			int pos = (int) (Math.random() * numCartas);
			Carta tmp = cartas[n];
			cartas[n] = cartas[pos];
			cartas[pos] = tmp;
		}
	}

	@Override
	public Carta extraerCarta() {
		if (estaVacio()) {
			return null;
		}
		Carta tmp = getUltimaCarta();
		cartas[numCartas - 1] = null;
		numCartas--;
		tmp.setMazo(null);
		return tmp;
	}

	@Override
	public boolean agregarCarta(Carta carta, boolean sinReglas) {
		cartas[numCartas] = carta;
		numCartas++;
		carta.setMazo(this);
		return true;
	}

	@Override
	public boolean agregarCarta(Carta carta) {
		return agregarCarta(carta, true);
	}

	@Override
	public Carta getUltimaCarta() {
		if (estaVacio()) {
			return null;
		}
		return cartas[numCartas - 1];
	}

	@Override
	public boolean estaVacio() {
		return numCartas == 0;
	}

	@Override
	public boolean puedoAgregarCarta(Carta carta) {
		return true;
	}

	@Override
	public Carta getUltimaCarta(int numCartaDesdeElFinal) {
		if (estaVacio()) {
			return null;
		}
		return cartas[(numCartas  -1) - numCartaDesdeElFinal];

	}

}
