package antonio.solitario;

import java.util.Vector;

public class Baraja extends Mazo {
	@Override
	public String toString() {
		return ""+getNumCartas();
	}

	public Baraja(){
		for(Palo p: Palo.values()){
			for(int n=0; n<13; n++){
				Carta c = new Carta(n+1, p);
				agregarCarta(c);
			}
		}
		barajar();
	}

}
