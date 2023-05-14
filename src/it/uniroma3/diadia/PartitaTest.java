package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	Partita p;
	Labirinto l;

	@Before
	public void setUp() {
		l=new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addAttrezzo("spada", 7)
				.addStanzaVincente("biblioteca")
				.addAdiacenza("atrio", "atrio", "atrio")
				.getLabirinto();
		p = new Partita(l);
		
	}
	
	
	@Test
	public void testGetStanzaCorrente() {
		Stanza s = new Stanza("atrio");
		assertEquals(s.getNome(), l.getStanzaCorrente().getNome());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("biblioteca", l.getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		Stanza s = new Stanza("atrio");
		assertEquals(s.getNome(), l.getStanzaCorrente().getNome());
	}

}
