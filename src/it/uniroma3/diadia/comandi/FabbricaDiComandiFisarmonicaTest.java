package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;

public class FabbricaDiComandiFisarmonicaTest {
	
	private Comando comando;
	private FabbricaDiComandiFisarmonica f;
	
	@Before
	public void setUp() {
		f = new FabbricaDiComandiFisarmonica();
		
	}

	@Test
	public void testComandoNonValido() {
		comando = new ComandoNonValido();
		assertEquals(comando.getNome(), f.costruisciComando("ruba").getNome());
		
	}
	
	@Test
	public void testComandoConParametro() {
		comando = new ComandoVai();
		comando.setParametro("sud");
		Comando crea = f.costruisciComando("vai sud");
		assertEquals(comando.getNome(), crea.getNome());
		assertEquals(comando.getParametro(), crea.getParametro());
		
	}
	
	@Test
	public void testComandoSenzaParametro() {
		comando = new ComandoAiuto();
		assertEquals(comando.getNome(), f.costruisciComando("aiuto").getNome());
			
	}

}
