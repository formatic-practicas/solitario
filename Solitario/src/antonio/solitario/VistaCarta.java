package antonio.solitario;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaCarta extends JPanel {
	public VistaCarta(Carta carta){
		JLabel l = new JLabel(carta.toString());
		add(l);
		setSize(250, 50);
	}
}
