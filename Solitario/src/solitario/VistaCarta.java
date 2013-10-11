package solitario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaCarta extends JPanel {
	public VistaCarta(Carta carta) {
		this.carta = carta;
		if (imagen == null) {
			try {
				imagen = ImageIO.read(new File("classic_13x4x560x780.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		setSize(56, 78);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int palo = carta.getPalo().ordinal();
		int numero = carta.getNumero() - 1;
		g.drawImage(imagen, 0, 0, 56, 78, numero * 560, palo * 780,
				numero * 560 + 560, palo * 780 + 780, null);
	}
	Carta carta;
	static BufferedImage imagen;
	public Carta getCarta() {
		return carta;
	}
}
