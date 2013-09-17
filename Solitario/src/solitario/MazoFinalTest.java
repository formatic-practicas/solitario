package solitario;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MazoFinalTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAgregarCarta() {
		MazoFinal mazoFinal = new MazoFinal();
		assertTrue(mazoFinal.estaVacio());
		Carta carta = new Carta(5, Palo.PICAS);
		assertFalse(mazoFinal.agregarCarta(carta));
		assertTrue(mazoFinal.estaVacio());
		carta = new Carta(1, Palo.PICAS);
		assertTrue(mazoFinal.agregarCarta(carta));
		assertFalse(mazoFinal.estaVacio());
		carta = new Carta(7, Palo.PICAS);
		assertFalse(mazoFinal.agregarCarta(carta));
		carta = new Carta(2, Palo.PICAS);
		assertTrue(mazoFinal.agregarCarta(carta));
		carta = new Carta(3, Palo.DIAMANTES);
		assertFalse(mazoFinal.agregarCarta(carta));

		
	}

}
