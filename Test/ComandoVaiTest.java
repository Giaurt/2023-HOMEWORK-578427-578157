package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	private Partita p;
	
	@Before
	public void setUp() {
		s1 = new Stanza("aula 1");
		s2 = new Stanza("aula 2");
		vai = new ComandoVai();
		p = new Partita();
		
	}
	
	@Test
	public void testVaiNull() {

		p.setStanzaCorrente(s1);
		vai.esegui(p);
		assertEquals(s1, p.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneNonEsiste() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("est", s2);
		vai.setParametro("nord");
		vai.esegui(p);
		assertNotEquals(s2, p.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneEsiste() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("nord", s2);
		vai.setParametro("nord");
		vai.esegui(p);
		assertEquals(s2, p.getStanzaCorrente());
		
	}

}
