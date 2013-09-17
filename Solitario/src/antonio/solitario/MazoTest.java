package antonio.solitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MazoTest {

	Mazo mazo;
	@Before
	public void setUp() throws Exception {
		mazo = new Mazo();
	}

	@After
	public void tearDown() throws Exception {
		mazo = null;
	}

	@Test
	public void testMazo() {
		assertTrue(mazo.getNumCartas() == 0);
	}

	@Test
	public void testGetNumCartas() {
		assertTrue(mazo.getNumCartas() == 0);
		Carta c = new Carta(4, Palo.DIAMANTES, Estado.BOCA_ABAJO);
		mazo.agregarCarta(c);
		assertTrue(mazo.getNumCartas() == 1);
	}

	@Test
	public void testBarajar() {

	}

	@Test
	public void testExtraerCarta() {
		Carta carta = new Carta(10, Palo.TREBOL, Estado.BOCA_ABAJO);
		assertTrue(mazo.getNumCartas() == 0);
		mazo.agregarCarta(carta);
		assertTrue(mazo.getNumCartas() == 1);
		Carta extraida = mazo.extraerCarta();
		assertTrue(mazo.getNumCartas() == 0);
		assertTrue(extraida.getPalo() == carta.getPalo());
		assertTrue(extraida.getNumero() == carta.getNumero());
		assertTrue(extraida.getEstado() == carta.getEstado());
	}

	@Test
	public void testGetUltimaCarta() {
		Carta carta = new Carta(10, Palo.TREBOL, Estado.BOCA_ABAJO);
		assertTrue(mazo.getNumCartas() == 0);
		mazo.agregarCarta(carta);
		assertTrue(mazo.getNumCartas() == 1);
		assertTrue(mazo.getUltimaCarta().getPalo() == Palo.TREBOL);
		assertTrue(mazo.getUltimaCarta().getNumero() == 10);
		assertTrue(mazo.getUltimaCarta().getEstado() == Estado.BOCA_ABAJO);
	}

	@Test
	public void testEstaVacio() {
		Carta carta = new Carta(10, Palo.TREBOL, Estado.BOCA_ABAJO);
		assertTrue(mazo.estaVacio());
		mazo.agregarCarta(carta);
		assertTrue(!mazo.estaVacio());
	}

}
