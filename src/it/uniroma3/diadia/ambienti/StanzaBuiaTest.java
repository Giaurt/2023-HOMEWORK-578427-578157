package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia sb;
	private Attrezzo torcia;
	
	
	@Before
	public void setUp() {
		sb = new StanzaBuia("StanzaBuia", "torcia");
		torcia = new Attrezzo("torcia", 1);
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		
		sb.addAttrezzo(torcia);
		assertEquals(sb.toString(), sb.getDescrizione());
		
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String stringa = "Qui c'è buio pesto";
		assertEquals(sb.getDescrizione(), stringa);
	}

}
