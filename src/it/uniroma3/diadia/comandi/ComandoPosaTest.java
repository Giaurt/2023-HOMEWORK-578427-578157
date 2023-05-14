package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	
	private Partita p;
	private Attrezzo attrezzo;
	private Comando comando;
	Labirinto l;
	
	@Before
	public void setUp() {
		
		l = new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addAttrezzo("martello", 3)
				.addStanza("biblioteca")
				.addAdiacenza("biblioteca", "atrio", "nord")
				.addStanzaVincente("biblioteca")
				.getLabirinto();
		p = new Partita(l);
		attrezzo = new Attrezzo("lancia", 4);
		comando = new ComandoPosa();
		
	}

	@Test
	public void testAttrezzoPosato() {
		
		p.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("lancia");
		comando.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("lancia"));
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("lancia"));
	}
	
	@Test
	public void testAttrezzoNonPosato() {
		comando.setParametro("lancia");
		comando.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("lancia"));
	}
	
	/*@Test
	public void testStanzaPiena() {
		
		for(int i=0; i<10; i++) {
			p.getStanzaCorrente().addAttrezzo(new Attrezzo("riempi"+i, 2));
		}
			
			p.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			comando.setParametro("lancia");
			comando.esegui(p);
			assertFalse(p.getStanzaCorrente().hasAttrezzo("lancia"));
		}*/
		
		
	}


