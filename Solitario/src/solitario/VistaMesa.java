package solitario;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaMesa extends JPanel {


	public VistaMesa(Mesa mesa) {
		this.mesa = mesa;
		setLayout(new BorderLayout());
		barajaSeleccionada = false;
		setSize(400, 400);
		panelCartas = new JPanel();
		panelCartas.setLayout(null);
		panelCartas.setBounds(getBounds());

		panelMazos = new JPanel();
		panelMazos.setLayout(null);

		panelMazos.setBounds(getBounds());

		add(panelCartas, BorderLayout.CENTER);
		panelCartas.setOpaque(false);
		add(panelMazos, BorderLayout.CENTER);
		estadoJuego = new EstadoJuego();
		add(estadoJuego, BorderLayout.SOUTH);

		colocarMazos(mesa);
		colocarCartas(mesa);
		actualizarEstadoJuego();

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
					if(VistaMesa.this.mesa.mazos[TipoMazo.BARAJA.ordinal()].estaVacio()){
						if(VistaMesa.this.mesa.numRepartos > 0){
							VistaMesa.this.mesa.moverDescarteABaraja();
							actualizarRepartos();
						}
					}else{
						VistaMesa.this.mesa.sacarDeBarajaADescarte();
					}
					actualizarCartas();
					barajaSeleccionada = false;
				} else {
					Component c = VistaMesa.this.panelMazos.getComponentAt(e
							.getPoint());
					if (c != null && c != VistaMesa.this.panelMazos) {
						VistaMazo vistaMazo = (VistaMazo) c;
						if (selected != null) {
							Carta carta = selected.getCarta();
							Mazo old = carta.getMazo();
							if (vistaMazo.mazo.puedoAgregarCarta(carta)) {
								old.extraerCarta();
								vistaMazo.mazo.agregarCarta(carta);
								actualizarPuntos();
							}
						}
					}
				}
				VistaMesa.this.colocarCartas(VistaMesa.this.mesa);
				selected = null;
			}
		});
	}

	public void actualizarEstadoJuego(){
		actualizarRepartos();
		actualizarCartas();
		actualizarPuntos();
	}
	protected void actualizarRepartos() {
		estadoJuego.setRepartos(VistaMesa.this.mesa.numRepartos);
	}

	protected void actualizarCartas() {
		estadoJuego.setCartas(this.mesa.mazos[TipoMazo.BARAJA.ordinal()].getNumCartas());
	}

	protected void actualizarPuntos() {
		int puntos = 0;
		for (int n = TipoMazo.FINAL1.ordinal(); n <= TipoMazo.FINAL4.ordinal(); n++) {
			puntos += this.mesa.mazos[n].getNumCartas();
		}
		estadoJuego.setPuntos(puntos);
		if (puntos == 52) {
			FinDeJuego f = new FinDeJuego();
			f.setVisible(true);
		}

	}

	private void colocarCartas(Mesa mesa) {
		panelCartas.removeAll();
		panelCartas.repaint();

		int columna=300;
		if (!mesa.mazos[TipoMazo.DESCARTE.ordinal()].estaVacio()) {
			VistaCarta vistaCartaDescarte = new VistaCarta(
					mesa.mazos[TipoMazo.DESCARTE.ordinal()].getUltimaCarta());
			panelCartas.add(vistaCartaDescarte);
			vistaCartaDescarte.setLocation(FILA_SUPERIOR, SEPARACION_HORIZONTAL +columna);
		}

		columna+= ANCHO_CARTA+SEPARACION_HORIZONTAL;
		if (!mesa.mazos[TipoMazo.INTERMEDIO1.ordinal()].estaVacio()) {
			VistaCarta intermedio1 = new VistaCarta(
					mesa.mazos[TipoMazo.INTERMEDIO1.ordinal()].getUltimaCarta());
			intermedio1.setLocation(columna, FILA_INFERIOR);
			panelCartas.add(intermedio1);
		}
		columna+= ANCHO_CARTA+SEPARACION_HORIZONTAL;
		if (!mesa.mazos[TipoMazo.INTERMEDIO2.ordinal()].estaVacio()) {
			VistaCarta intermedio2 = new VistaCarta(
					mesa.mazos[TipoMazo.INTERMEDIO2.ordinal()].getUltimaCarta());
			intermedio2.setLocation(columna,  FILA_INFERIOR);
			panelCartas.add(intermedio2);
		}
		columna+= ANCHO_CARTA+SEPARACION_HORIZONTAL;
		if (!mesa.mazos[TipoMazo.INTERMEDIO3.ordinal()].estaVacio()) {
			VistaCarta intermedio3 = new VistaCarta(
					mesa.mazos[TipoMazo.INTERMEDIO3.ordinal()].getUltimaCarta());
			intermedio3.setLocation(columna,  FILA_INFERIOR);
			panelCartas.add(intermedio3);
		}
		columna+= ANCHO_CARTA+SEPARACION_HORIZONTAL;
		if (!mesa.mazos[TipoMazo.INTERMEDIO4.ordinal()].estaVacio()) {
			VistaCarta intermedio4 = new VistaCarta(
					mesa.mazos[TipoMazo.INTERMEDIO4.ordinal()].getUltimaCarta());
			intermedio4.setLocation(columna,  FILA_INFERIOR);
			panelCartas.add(intermedio4);
		}
		columna=300;
		if (!mesa.mazos[TipoMazo.FINAL1.ordinal()].estaVacio()) {
			VistaCarta final1 = new VistaCarta(
					mesa.mazos[TipoMazo.FINAL1.ordinal()].getUltimaCarta());
			final1.setLocation(columna, FILA_SUPERIOR);
			panelCartas.add(final1);
		}
		columna+= ANCHO_CARTA+SEPARACION_HORIZONTAL;
		if (!mesa.mazos[TipoMazo.FINAL2.ordinal()].estaVacio()) {
			VistaCarta final2 = new VistaCarta(
					mesa.mazos[TipoMazo.FINAL2.ordinal()].getUltimaCarta());
			final2.setLocation(columna, FILA_SUPERIOR);
			panelCartas.add(final2);
		}
		columna+= ANCHO_CARTA+SEPARACION_HORIZONTAL;
		if (!mesa.mazos[TipoMazo.FINAL3.ordinal()].estaVacio()) {
			VistaCarta final3 = new VistaCarta(
					mesa.mazos[TipoMazo.FINAL3.ordinal()].getUltimaCarta());
			final3.setLocation(columna, FILA_SUPERIOR);
			panelCartas.add(final3);
		}
		columna+= ANCHO_CARTA+SEPARACION_HORIZONTAL;
		if (!mesa.mazos[TipoMazo.FINAL4.ordinal()].estaVacio()) {
			VistaCarta final4 = new VistaCarta(
					mesa.mazos[TipoMazo.FINAL4.ordinal()].getUltimaCarta());
			final4.setLocation(columna, FILA_SUPERIOR);
			panelCartas.add(final4);
		}
		panelCartas.revalidate();
		panelCartas.repaint();

	}

	private void colocarMazos(Mesa mesa) {
		int columna=0;
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
	private VistaCarta selected;
	JPanel panelCartas, panelMazos;
	EstadoJuego estadoJuego;
	final int ANCHO_CARTA=560;
	final int ALTO_CARTA = 780;
	final int SEPARACION_HORIZONTAL = 5;
	final int SEPARACION_VERTICAL = 5;
	final int FILA_SUPERIOR= 10;
	final int FILA_INFERIOR= FILA_SUPERIOR+ALTO_CARTA+SEPARACION_VERTICAL;

}
