package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {
	
	Giocatore g = new Giocatore();

	@Test
	public void testGetBorsa() {
		assertNotNull(g.getBorsa());
	}

	@Test
	public void testGetCfu() {
		assertEquals(20, g.getCfu());
	}

	@Test
	public void testSetCfu() {
		g.setCfu(18);
		assertEquals(18, g.getCfu());
	}

}
