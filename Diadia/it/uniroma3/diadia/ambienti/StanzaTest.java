package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	Partita p = new Partita();
	Stanza s1 = new Stanza("Stanza1");
	Stanza s2 = new Stanza("Stanza2");
	Labirinto l = new Labirinto();
	Attrezzo a = new Attrezzo("spada", 4);

	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente("sud", s2);
		assertEquals(s2, s1.getStanzaAdiacente("sud"));
	}

	@Test
	public void testAddAttrezzo() {
		s1.addAttrezzo(a);
		assertEquals(a, s1.getAttrezzo("spada"));
	}

}