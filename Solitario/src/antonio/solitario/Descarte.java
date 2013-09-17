package antonio.solitario;

public class Descarte extends Mazo {
	@Override
	public String toString() {
		if(estaVacio()){
			return "{}";
		}
		return "{"+ getUltimaCarta().toString()+"}";
	}
}
