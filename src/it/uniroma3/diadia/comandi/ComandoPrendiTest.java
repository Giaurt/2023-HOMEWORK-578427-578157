package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	private Labirinto l;
	private Partita p;
	private Attrezzo attrezzo;
	private Comando comando;
	
	
	@Before
	public void setUp() {
		l=new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("biblioteca")
				.getLabirinto();
		
		p = new Partita(l);
		attrezzo = new Attrezzo("torcia", 1);
		comando = new ComandoPrendi();
	}

	@Test
	public void testAttrezzoPreso() {
		comando.setParametro("martello");
		comando.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("martello"));	
		assertFalse(l.getStanzaCorrente().hasAttrezzo("martello"));
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
