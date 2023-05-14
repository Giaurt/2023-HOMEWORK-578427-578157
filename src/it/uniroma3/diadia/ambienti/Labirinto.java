package it.uniroma3.diadia.ambienti;

public class Labirinto{
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public Stanza entrata;
	public Stanza uscita;
	


/*
	public void creaStanze() {

		// crea gli attrezzi
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo martello = new Attrezzo("martello", 3);
		Attrezzo spada = new Attrezzo("spada", 7);
		Attrezzo cerbottana = new Attrezzo("cerbottana", 6);
		Attrezzo ombrello = new Attrezzo("ombrello", 2);
    	
		// crea stanze del labirinto 
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		// collega le stanze 
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze 
		aulaN10.addAttrezzo(lanterna);
	    atrio.addAttrezzo(martello);
		atrio.addAttrezzo(osso);
		aulaN10.addAttrezzo(ombrello);
		laboratorio.addAttrezzo(spada);
		laboratorio.addAttrezzo(cerbottana);
		
		
		// il gioco comincia nell'atrio
        this.entrata = atrio;  
		this.uscita = biblioteca;
		
    }*/
	public LabirintoBuilder getLabBuild() {
		return new LabirintoBuilder();
	}
	
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza setUscita() {
		return this.uscita;
	}
	public Stanza getStanzaIniziale() {
		return this.stanzaCorrente;
	}
	
	public void setEntrata(Stanza s) {
		this.entrata = s;
	}


}
