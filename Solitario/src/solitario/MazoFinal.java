package solitario;



public class MazoFinal extends Mazo {
	@Override
	public String toString() {
		if(estaVacio()){
			return "()";
		}
		return "(" + getUltimaCarta().toString() + ")";
	}
	@Override
	public boolean agregarCarta(Carta carta) {
		if(estaVacio()){
			if(carta.getNumero() == 1){
				return super.agregarCarta(carta);
			}
		}else{
			if(carta.getPalo() == getUltimaCarta().getPalo()){
				if(carta.getNumero() == getUltimaCarta().getNumero()+1){
					return super.agregarCarta(carta);
				}
			}
		}
		return false;
	}
}
