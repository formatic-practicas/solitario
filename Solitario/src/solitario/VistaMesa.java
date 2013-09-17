package solitario;


import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaMesa extends JPanel {

	private VistaMazo selected;
	public VistaMesa(Mesa mesa){
		this.mesa = mesa;
		setLayout(null);
		
		VistaMazo vistaBaraja = new VistaMazo(mesa.mazos[TipoMazo.BARAJA.ordinal()]);
		add(vistaBaraja);
		vistaBaraja.setLocation(0,5);
		
		VistaMazo vistaDescarte = new VistaMazo(mesa.mazos[TipoMazo.DESCARTE.ordinal()]);
		add(vistaDescarte);
		vistaDescarte.setLocation(60,5);	

		VistaMazo final1 = new VistaMazo(mesa.mazos[TipoMazo.FINAL1.ordinal()]);
		final1.setLocation(120,5);
		add(final1);
		
		VistaMazo final2 = new VistaMazo(mesa.mazos[TipoMazo.FINAL2.ordinal()]);
		final2.setLocation(182, 5);
		add(final2);
		
		VistaMazo final3 = new VistaMazo(mesa.mazos[TipoMazo.FINAL3.ordinal()]);
		final3.setLocation(241, 5);
		add(final3);
		
		VistaMazo final4 = new VistaMazo(mesa.mazos[TipoMazo.FINAL4.ordinal()]);
		final4.setLocation(301, 5);
		add(final4);

		VistaMazo intermedio1 = new VistaMazo(mesa.mazos[TipoMazo.INTERMEDIO1.ordinal()]);
		intermedio1.setLocation(120,75);
		add(intermedio1);
		
		VistaMazo intermedio2 = new VistaMazo(mesa.mazos[TipoMazo.INTERMEDIO2.ordinal()]);
		intermedio2.setLocation(182, 75);
		add(intermedio2);
		
		VistaMazo intermedio3 = new VistaMazo(mesa.mazos[TipoMazo.INTERMEDIO3.ordinal()]);
		intermedio3.setLocation(241, 75);
		add(intermedio3);
		
		VistaMazo intermedio4 = new VistaMazo(mesa.mazos[TipoMazo.INTERMEDIO4.ordinal()]);
		intermedio4.setLocation(301, 75);
		add(intermedio4);
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(selected!= null){
					selected.setLocation(e.getPoint());
				}
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Component c = VistaMesa.this.getComponentAt(e.getPoint());
				if(c!= null && c != VistaMesa.this){
					selected = (VistaMazo)c;
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				selected = null;
			}
		});	
	}
	
	Mesa mesa;
	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		VistaMesa v = new VistaMesa(mesa);
		JFrame f = new JFrame();
		f.getContentPane().add(v);
		f.setSize(400,400);
		f.setVisible(true);
	}
}
