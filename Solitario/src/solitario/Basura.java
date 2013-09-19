package solitario;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Basura extends JPanel {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setLayout(null);
		JPanel a = new JPanel();
		a.setBackground(java.awt.Color.red);
		a.setLocation(10,10);
		a.setSize(50,50);
		f.add(a);
		JPanel b = new JPanel();
		b.setSize(50,50);
		b.setLocation(20, 20);
		b.setBackground(java.awt.Color.green);
		f.add(b);
		
		//f.add(new Basura());
		f.setSize(380,213);
		f.setVisible(true);
	}
//	ImageIcon image;
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        image.paintIcon(this, g, 0,0);
//    }
//	public Basura() {
//		setSize(80,113);
//	    image = new ImageIcon("baraja.jpg");
//	}
}
