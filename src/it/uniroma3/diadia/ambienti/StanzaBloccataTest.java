package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata sb;
	private Stanza s;
	private Attrezzo a;
	
	
	@Before
	public void setUp() {
		sb = new StanzaBloccata("StanzaBloccata", "nord", "chiave");
		s = new Stanza("Stanza");
		a = new Attrezzo("chiave", 1);
		sb.impostaStanzaAdiacente("nord", s);
	}

	@Test
	public void testDirezioneBloccata() {
		
		assertEquals(sb, sb.getStanzaAdiacente("nord"));

	}
	
	@Test
	public void testDirezioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(s, sb.getStanzaAdiacente("nord"));
		
	}
	@Test
	public void testDescrizioneSbloccata() {
		sb.addAttrezzo(a);
		assertEquals(sb.toString(), sb.getDescrizione());
	}

}
