package solitario;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaCarta extends JPanel {
	public VistaCarta(Carta carta){
		setBackground(java.awt.Color.WHITE);		
		JLabel l = new JLabel(carta.toString());
		if(carta.getColor() == Color.ROJO){
			l.setForeground(java.awt.Color.RED);
		}
		add(l);
		setSize(250, 50);
	}
}
