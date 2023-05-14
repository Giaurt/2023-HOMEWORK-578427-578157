package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private Labirinto l;
	private Comando vai;
	private Partita p;
	
	@Before
	public void setUp() {
		l = new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addStanzaVincente("biblioteca")
				.addAdiacenza("atrio", "biblioteca", "nord")
				.getLabirinto();
				
				

		vai = new ComandoVai();
		p = new Partita(l);
		
	}
	
	@Test
	public void testVaiNull() {
		Stanza s = new Stanza("atrio");
		vai.esegui(p);
		assertEquals(s.getNome(), l.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVaiDirezioneNonEsiste() {
		vai.setParametro("est");
		vai.esegui(p);
		assertNotEquals(l.getStanzaVincente(), l.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneEsiste() {
		vai.setParametro("nord");
		vai.esegui(p);
		assertEquals(l.getStanzaVincente(), l.getStanzaCorrente());
		
	}

}
