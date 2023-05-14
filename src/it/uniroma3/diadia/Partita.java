package it.uniroma3.diadia;


import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
//	private Giocatore giocatore;
	
	Giocatore giocatore;
	
	Labirinto lab;
	
	
	
	public Partita(Labirinto l){
		
		giocatore = new Giocatore();
		this.lab = l;
		//lab.creaStanze();
		this.stanzaCorrente = lab.entrata;
		this.stanzaVincente = lab.uscita;
		
		this.finita = false;
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
	
	public Labirinto getLabirinto() {
		return lab;
	}

	public Stanza getStanzaVincente() {
		return this.getLabirinto().getStanzaVincente();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.getLabirinto().setStanzaCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return this.getLabirinto().getStanzaCorrente();
	}
	
	public Giocatore getGiocatore() {
		return giocatore;
	}
	
	public boolean giocatoreIsVivo() {
		return this.getGiocatore().getCfu()>0;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return lab.getStanzaCorrente()== lab.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	
}
