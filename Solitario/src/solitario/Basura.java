package solitario;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Basura extends JFrame {
	public static void main(String[] args) {
		new Basura();
	}
	JPanel selected;
	public Basura() {
		getContentPane().setLayout(null);
		JPanel p = new JPanel();
		p.setSize(50, 50);
		p.add(new JLabel("Hola"));
		getContentPane().add(p);
		p.setBackground(java.awt.Color.red);
	
		JPanel q = new JPanel();
		q.setSize(50, 50);
		q.add(new JLabel("Adios"));
		getContentPane().add(q);
		q.setBackground(java.awt.Color.green);
		
		JPanel r = new JPanel();
		r.setSize(70, 70);
		r.add(new JLabel("Destino"));
		getContentPane().add(r);
		r.setBackground(java.awt.Color.yellow);
		
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selected = null;
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Component c = Basura.this.getContentPane().getComponentAt(
						e.getPoint());
				if (c != getContentPane()) {
					selected = (JPanel) c;
					System.out.println();
				}

			}
		});
		getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (selected != null) {
					selected.setLocation(e.getPoint());
				}
			}
		});
		setSize(200, 200);
		setVisible(true);
	}
}
