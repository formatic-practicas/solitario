package solitario;
/*
 * Cada palo mide: 560 * 780
 * 
 */
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Basura extends JPanel {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setLayout(null);
		f.add(new Basura());
		f.setSize(380, 213);
		f.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, 56, 78, palo*560, numero*780, palo*560+560 ,
				numero*780+780, null);
	}

	public Basura() {
		setSize(56, 78);
		try {
			image = ImageIO.read(new File("classic_13x4x560x780.png"));
			width = 560;
			height = 780;
			palo = 0;
			numero=0;
		} catch (IOException ex) {

		}
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				palo++;
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				numero++;
				repaint();
			}
			
		});

	}

	BufferedImage image;
	int palo;
	int numero;
	int width, height;
}
