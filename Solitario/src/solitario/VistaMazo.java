package solitario;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaMazo extends JPanel {

	public VistaMazo(Mazo mazo){
		this.mazo = mazo;
		setBackground(java.awt.Color.GREEN);
		setSize(50, 50);
	}

	public Mazo getMazo() {
		return mazo;
	}
	Mazo mazo;
}
