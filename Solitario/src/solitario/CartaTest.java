package solitario;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CartaTest {
	Carta carta;
	@Before
	public void setUp() throws Exception {
		carta = new Carta(1, Palo.DIAMANTES, Estado.BOCA_ARRIBA);
	}

	@After
	public void tearDown() throws Exception {
		carta = null;
	}

	@Test
	public void testCarta() {
		assertTrue(carta.getNumero() == 1);
		assertTrue(carta.getColor() == Color.ROJO);
		assertTrue(carta.getPalo() == Palo.DIAMANTES);
		assertTrue(carta.getEstado() == Estado.BOCA_ARRIBA);
	}

	@Test
	public void testGetEstado() {
		carta.setEstado(Estado.BOCA_ABAJO);
		assertTrue(carta.getEstado() == Estado.BOCA_ABAJO);
		carta.setEstado(Estado.BOCA_ARRIBA);
		assertTrue(carta.getEstado() == Estado.BOCA_ARRIBA);	}


	@Test
	public void testGetPalo() {
		carta.setPalo(Palo.PICAS);
		assertTrue(carta.getPalo()== Palo.PICAS);
		carta.setPalo(Palo.TREBOL);
		assertTrue(carta.getPalo()== Palo.TREBOL);
		carta.setPalo(Palo.CORAZONES);
		assertTrue(carta.getPalo()== Palo.CORAZONES);
		carta.setPalo(Palo.DIAMANTES);
		assertTrue(carta.getPalo()== Palo.DIAMANTES);
	}



	@Test
	public void testGetColor() {
		carta.setPalo(Palo.PICAS);
		assertTrue(carta.getColor() == Color.NEGRO);
		carta.setPalo(Palo.TREBOL);
		assertTrue(carta.getColor() == Color.NEGRO);
		carta.setPalo(Palo.CORAZONES);
		assertTrue(carta.getColor() == Color.ROJO);
		carta.setPalo(Palo.DIAMANTES);
		assertTrue(carta.getColor() == Color.ROJO);

	}


	@Test
	public void testGetNumero() {
		for(int n=1; n<=13; n++){
			carta.setNumero(n);
			assertTrue(carta.getNumero() == n);
		}
	}
}
