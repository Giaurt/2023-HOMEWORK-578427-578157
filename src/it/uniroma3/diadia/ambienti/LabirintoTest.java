package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	Labirinto l;
	
	@Before
	public void setUp() {
		l = new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addAttrezzo("martello", 3)

				.addStanzaVincente("biblioteca")
				.addAdiacenza("atrio", "biblioteca", "nord")
				.getLabirinto();
		
	}
	

	@Test
	public void testSetUscita() {
		assertEquals("biblioteca", l.getStanzaVincente().getNome());
	}

	@Test
	public void testGetEntrata() {
		assertEquals("atrio", l.getStanzaCorrente().getNome());
	}
	
	public void testGetAttrezzo() {
		assertEquals("martello", l.getStanzaCorrente().getAttrezzo("martello").getNome());
	}
	

}
