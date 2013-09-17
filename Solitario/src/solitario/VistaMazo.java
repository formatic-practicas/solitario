package solitario;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaMazo extends JPanel {

	public VistaMazo(Mazo mazo){
		this.mazo = mazo;
		setBackground(java.awt.Color.WHITE);
		JLabel l = new JLabel(mazo.toString());
		if(!mazo.estaVacio() && mazo.getUltimaCarta().getColor() == Color.ROJO){
			l.setForeground(java.awt.Color.RED);
		}
		add(l);
		setSize(50, 50);
	}

	public Mazo getMazo() {
		return mazo;
	}
	Mazo mazo;
}
