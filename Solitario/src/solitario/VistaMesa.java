package solitario;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaMesa extends JPanel {

	private VistaCarta selected;
	JPanel panelCartas, panelMazos;

	public VistaMesa(Mesa mesa) {
		this.mesa = mesa;
		barajaSeleccionada = false;
		setSize(400, 400);
		panelCartas = new JPanel();
		panelCartas.setLayout(null);
		panelCartas.setBounds(getBounds());
		panelMazos = new JPanel();
		panelMazos.setLayout(null);
		panelMazos.setBounds(getBounds());
		setLayout(null);
		add(panelCartas);
		panelCartas.setOpaque(false);
		add(panelMazos);

		colocarMazos(mesa);
		colocarCartas(mesa);
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (selected != null) {
					selected.setLocation(e.getPoint());
				}
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Component b = VistaMesa.this.panelMazos.getComponentAt(e
						.getPoint());
				if (b != null && b == vistaBaraja) {
					barajaSeleccionada = true;
				} else {
					Component c = VistaMesa.this.panelCartas.getComponentAt(e
							.getPoint());
					if (c != null && c != VistaMesa.this.panelCartas) {
						selected = (VistaCarta) c;
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (barajaSeleccionada) {
					VistaMesa.this.mesa.sacarDeBarajaADescarte();
					barajaSeleccionada = false;
				} else {
					Component c = VistaMesa.this.panelMazos.getComponentAt(e
							.getPoint());
					if (c != null && c != VistaMesa.this.panelMazos) {
						VistaMazo vistaMazo = (VistaMazo) c;
						if (selected != null) {
							Carta carta = selected.getCarta();
							Mazo old = carta.getMazo();
							if(vistaMazo.mazo.puedoAgregarCarta(carta)){
								old.extraerCarta();
								vistaMazo.mazo.agregarCarta(carta);
							}
						}
					}
				}
				VistaMesa.this.colocarCartas(VistaMesa.this.mesa);
				selected = null;
			}
		});
	}

	private void colocarCartas(Mesa mesa) {
		panelCartas.removeAll();
		panelCartas.repaint();

		if (!mesa.mazos[TipoMazo.DESCARTE.ordinal()].estaVacio()) {
			VistaCarta vistaCartaDescarte = new VistaCarta(
					mesa.mazos[TipoMazo.DESCARTE.ordinal()].getUltimaCarta());
			panelCartas.add(vistaCartaDescarte);
			vistaCartaDescarte.setLocation(60, 5);
		}

		if (!mesa.mazos[TipoMazo.INTERMEDIO1.ordinal()].estaVacio()) {
			VistaCarta intermedio1 = new VistaCarta(
					mesa.mazos[TipoMazo.INTERMEDIO1.ordinal()].getUltimaCarta());
			intermedio1.setLocation(120, 75);
			panelCartas.add(intermedio1);
		}

		if (!mesa.mazos[TipoMazo.INTERMEDIO2.ordinal()].estaVacio()) {
			VistaCarta intermedio2 = new VistaCarta(
					mesa.mazos[TipoMazo.INTERMEDIO2.ordinal()].getUltimaCarta());
			intermedio2.setLocation(182, 75);
			panelCartas.add(intermedio2);
		}

		if (!mesa.mazos[TipoMazo.INTERMEDIO3.ordinal()].estaVacio()) {
			VistaCarta intermedio3 = new VistaCarta(
					mesa.mazos[TipoMazo.INTERMEDIO3.ordinal()].getUltimaCarta());
			intermedio3.setLocation(241, 75);
			panelCartas.add(intermedio3);
		}

		if (!mesa.mazos[TipoMazo.INTERMEDIO4.ordinal()].estaVacio()) {
			VistaCarta intermedio4 = new VistaCarta(
					mesa.mazos[TipoMazo.INTERMEDIO4.ordinal()].getUltimaCarta());
			intermedio4.setLocation(301, 75);
			panelCartas.add(intermedio4);
		}

		if (!mesa.mazos[TipoMazo.FINAL1.ordinal()].estaVacio()) {
			VistaCarta final1 = new VistaCarta(
					mesa.mazos[TipoMazo.FINAL1.ordinal()].getUltimaCarta());
			final1.setLocation(120, 5);
			panelCartas.add(final1);
		}

		if (!mesa.mazos[TipoMazo.FINAL2.ordinal()].estaVacio()) {
			VistaCarta final2 = new VistaCarta(
					mesa.mazos[TipoMazo.FINAL2.ordinal()].getUltimaCarta());
			final2.setLocation(182, 5);
			panelCartas.add(final2);
		}

		if (!mesa.mazos[TipoMazo.FINAL3.ordinal()].estaVacio()) {
			VistaCarta final3 = new VistaCarta(
					mesa.mazos[TipoMazo.FINAL3.ordinal()].getUltimaCarta());
			final3.setLocation(241, 5);
			panelCartas.add(final3);
		}

		if (!mesa.mazos[TipoMazo.FINAL4.ordinal()].estaVacio()) {
			VistaCarta final4 = new VistaCarta(
					mesa.mazos[TipoMazo.FINAL4.ordinal()].getUltimaCarta());
			final4.setLocation(301, 5);
			panelCartas.add(final4);
		}
		panelCartas.revalidate();
		panelCartas.repaint();

	}

	private void colocarMazos(Mesa mesa) {
		vistaBaraja = new VistaMazo(mesa.mazos[TipoMazo.BARAJA.ordinal()]);
		panelMazos.add(vistaBaraja);
		vistaBaraja.setLocation(0, 5);

		VistaMazo vistaDescarte = new VistaMazo(
				mesa.mazos[TipoMazo.DESCARTE.ordinal()]);
		panelMazos.add(vistaDescarte);
		vistaDescarte.setLocation(60, 5);

		VistaMazo final1 = new VistaMazo(mesa.mazos[TipoMazo.FINAL1.ordinal()]);
		final1.setLocation(120, 5);
		panelMazos.add(final1);

		VistaMazo final2 = new VistaMazo(mesa.mazos[TipoMazo.FINAL2.ordinal()]);
		final2.setLocation(182, 5);
		panelMazos.add(final2);

		VistaMazo final3 = new VistaMazo(mesa.mazos[TipoMazo.FINAL3.ordinal()]);
		final3.setLocation(241, 5);
		panelMazos.add(final3);

		VistaMazo final4 = new VistaMazo(mesa.mazos[TipoMazo.FINAL4.ordinal()]);
		final4.setLocation(301, 5);
		panelMazos.add(final4, 0);

		VistaMazo intermedio1 = new VistaMazo(
				mesa.mazos[TipoMazo.INTERMEDIO1.ordinal()]);
		intermedio1.setLocation(120, 75);
		panelMazos.add(intermedio1);

		VistaMazo intermedio2 = new VistaMazo(
				mesa.mazos[TipoMazo.INTERMEDIO2.ordinal()]);
		intermedio2.setLocation(182, 75);
		panelMazos.add(intermedio2);

		VistaMazo intermedio3 = new VistaMazo(
				mesa.mazos[TipoMazo.INTERMEDIO3.ordinal()]);
		intermedio3.setLocation(241, 75);
		panelMazos.add(intermedio3);

		VistaMazo intermedio4 = new VistaMazo(
				mesa.mazos[TipoMazo.INTERMEDIO4.ordinal()]);
		intermedio4.setLocation(301, 75);
		panelMazos.add(intermedio4);
	}

	Mesa mesa;
	private VistaMazo vistaBaraja;
	boolean barajaSeleccionada;

	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		VistaMesa v = new VistaMesa(mesa);
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(v);
		f.setSize(400, 400);
		f.setVisible(true);
	}
}
