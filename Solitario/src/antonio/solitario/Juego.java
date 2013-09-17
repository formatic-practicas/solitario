package antonio.solitario;

import java.util.Scanner;

public class Juego {
	Mesa mesa;

	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.play();
	}

	public Juego() {
		mesa = new Mesa();
	}

	private void play() {
		TipoMazo tipoMazo;
		while (true) {
			do {
				System.out.println(mesa.toString());
				System.out.println("De qué mazo desea coger carta?");
				int n = elegirMazo();
				tipoMazo = TipoMazo.values()[n];
			} while (!mesa.elegirMazoDesde(tipoMazo));

			System.out.println("En qué mazo desea colocar la carta?");
			int n = elegirMazo();
			tipoMazo = TipoMazo.values()[n];
			mesa.elegirMazoHasta(tipoMazo);
		}
	}

	private int elegirMazo() {
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
}
