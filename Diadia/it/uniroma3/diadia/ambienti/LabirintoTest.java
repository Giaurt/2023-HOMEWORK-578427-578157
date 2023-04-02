package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {
	Labirinto l = new Labirinto();
	

	@Test
	public void testSetUscita() {
		l.creaStanze();
		assertEquals("Biblioteca", l.setUscita().getNome());
	}

	@Test
	public void testGetEntrata() {
		l.creaStanze();
		assertEquals("Atrio", l.getEntrata().getNome());
	}
	

}
