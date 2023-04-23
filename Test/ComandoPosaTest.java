package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	
	private Partita p;
	private Attrezzo attrezzo;
	private Comando comando;
	
	@Before
	public void setUp() {
		p = new Partita();
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
	
	@Test
	public void testStanzaPiena() {
		
		for(int i=0; i<10; i++) {
			p.getStanzaCorrente().addAttrezzo(new Attrezzo("riempi"+i, 2));
		}
			
			p.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			comando.setParametro("lancia");
			comando.esegui(p);
			assertFalse(p.getStanzaCorrente().hasAttrezzo("lancia"));
		}
		
		
	}


