package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa b = new Borsa();
	Attrezzo a = new Attrezzo("chiave inglese", 3);
	Attrezzo c = new Attrezzo("motosega", 3);

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
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		b.addAttrezzo(a);
		b.addAttrezzo(c);
		assertEquals(b.getSortedSetOrdinatoPerPeso().first(), a);
		assertEquals(b.getSortedSetOrdinatoPerPeso().last(), c);
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		b.addAttrezzo(a);
		b.addAttrezzo(c);
		assertEquals(b.getContenutoOrdinatoPerPeso().get(0), a);
		assertEquals(b.getContenutoOrdinatoPerPeso().get(1), c);
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		b.addAttrezzo(a);
		b.addAttrezzo(c);
		assertEquals(b.getContenutoOrdinatoPerNome().first(), a);
		assertEquals(b.getContenutoOrdinatoPerNome().last(), c);
		
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Attrezzo f = new Attrezzo("martello", 2);
		b.addAttrezzo(a);
		b.addAttrezzo(c);
		b.addAttrezzo(f);
		assertTrue(b.getContenutoRaggruppatoPerPeso().get(a.getPeso()).contains(a));
		assertTrue(b.getContenutoRaggruppatoPerPeso().get(c.getPeso()).contains(c));
		assertFalse(b.getContenutoRaggruppatoPerPeso().get(a.getPeso()).contains(f));
	}

}
