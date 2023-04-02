package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa b = new Borsa();
	Attrezzo a = new Attrezzo("chiave inglese", 3);

	@Test
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(a));
	}

	@Test
	public void testGetAttrezzo() {
		b.addAttrezzo(a);
		assertEquals(a, b.getAttrezzo(a.getNome()));
	}

	@Test
	public void testRemoveAttrezzo() {
		b.addAttrezzo(a);
		assertEquals(a.getNome(), b.removeAttrezzo(a.getNome()).getNome());
	}

}
