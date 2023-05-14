package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	Partita p;
	Labirinto l;
	Attrezzo a;
	
	@Before
	public void setUp() {
		l = new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addAttrezzo("martello", 2)

				.addStanzaVincente("biblioteca")
				.addAdiacenza("atrio", "biblioteca", "nord")
				.getLabirinto();
		p = new Partita(l);
		a = new Attrezzo("martello", 2);
		
		
	}

	@Test
	public void testGetStanzaAdiacente() {
		assertNull(l.getStanzaCorrente().getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente() {
		assertEquals(l.getStanzaCorrente().getStanzaAdiacente("nord"), l.getStanzaVincente());
	}

	@Test
	public void testAddAttrezzo() {
		assertEquals(a.getNome(), l.getStanzaCorrente().getAttrezzo("martello").getNome());
		assertEquals(a.getPeso(), l.getStanzaCorrente().getAttrezzo("martello").getPeso());
	}

}