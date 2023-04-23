package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	private Partita p;
	private Attrezzo attrezzo;
	private Comando comando;
	
	
	@Before
	public void setUp() {
		p = new Partita();
		attrezzo = new Attrezzo("torcia", 1);
		comando = new ComandoPrendi();
	}

	@Test
	public void testAttrezzoPreso() {
		p.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("torcia");
		comando.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("torcia"));	
		assertFalse(p.getStanzaCorrente().hasAttrezzo("torcia"));
	}
	
	@Test
	public void testAttrezzoNonPreso() {
		comando.setParametro("torcia");
		comando.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("torcia"));
	}
	
	@Test
	public  void testBorsaPiena() {
		for(int i=0; i<10; i++) {
			p.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("chiave"+i, 1));
		}
		p.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("torcia");
		comando.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("torcia"));
	}
}
