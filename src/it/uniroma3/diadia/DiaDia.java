package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *         
 * @version base
 */

public class DiaDia{

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	

	private Partita partita;
	private IO inOut;

	public DiaDia(IO console, Labirinto lab) {
		this.inOut = console;
		this.partita = new Partita(lab);
		
	}
	

	public void gioca() {
		String istruzione;

		inOut.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = inOut.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		
	/*	if(comandoDaEseguire.getNome()==null) {
			inOut.mostraMessaggio("Non hai inserito nulla.");
		}else
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro());}
		else if (comandoDaEseguire.getNome().equals("posa")) {
			this.posa(comandoDaEseguire.getParametro());}
		else {
			inOut.mostraMessaggio("Comando sconosciuto");}  */
		if (this.partita.vinta()) 
			inOut.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo()) {
			inOut.mostraMessaggio("Hai finito i cfu. Partita conclusa.");
		}
	    return this.partita.isFinita();

	}   

	

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	

	/*Prendi*/

/*	private void prendi(String nomeAttrezzo) {
		boolean noAttrezzi = false;
		if(nomeAttrezzo==null) {
			if(this.partita.getStanzaCorrente().numeroAttrezzi!=0) {
				inOut.mostraMessaggio("Quale attrezzo vuoi prendere?");
				inOut.mostraMessaggio(this.partita.getStanzaCorrente().toStringAttrezzi());

				String istruzione;

				do		
					istruzione = inOut.leggiRiga();
				while (!processaIstruzione(istruzione));
			}else {
				inOut.mostraMessaggio("Non ci sono attrezzi nella stanza");
				noAttrezzi = true;
			}
			}
		
		if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)){
			
			Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(this.partita.getGiocatore().getBorsa().contrPeso(attrezzo)) {
				this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);

				inOut.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
				
			}else {
				inOut.mostraMessaggio("La borsa è troppo piena.");
			}
			
		}else if(!noAttrezzi){
			inOut.mostraMessaggio("L'attrezzo non è presente nella stanza.");
		}
	}
	*/
	

/*	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			inOut.mostraMessaggio("Quale attrezzo vuoi posare? ");
			inOut.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
			String istruzione;

			do		
				istruzione = inOut.leggiRiga();
			while (!processaIstruzione(istruzione));

		}if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			inOut.mostraMessaggio("Attrezzo " + attrezzo.getNome() + " posato correttamente");
		}else {
			inOut.mostraMessaggio("L'attrezzo non è presente nella borsa.");
		}
	}
	*/

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
/*	public void vai(String direzione) {
		if(direzione==null) {
			inOut.mostraMessaggio("Dove vuoi andare ?");
			inOut.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
			inOut.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
			
			String istruzione;

			do		
				istruzione = inOut.leggiRiga();
			while (!processaIstruzione(istruzione));

		}

		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			inOut.mostraMessaggio("Direzione inesistente");
		else {

			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);



		}
		inOut.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
		inOut.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());

	}
	
	*/


	/**
	 * Comando "Fine".
	 */
/*	private void fine() {
		inOut.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		System.exit(1);  
	}
	
	*/
	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addAttrezzo("spada", 5)
				.addStanza("Aula N10")
				.addAttrezzo("lanterna", 2)
				.addAttrezzo("chiave", 1)
				.addStanzaBloccata("Sgabuzzino", "ovest", "chiave")
				.addAdiacenza("Aula N10", "Sgabuzzino", "ovest")
				.addAdiacenza("Sgabuzzino", "Aula N10", "est")
				.addAdiacenza("Atrio", "Aula N10", "sud")
				.addAdiacenza("Aula N10", "Atrio", "nord")
				.addStanzaBuia("Bagno", "lanterna")
				.addAdiacenza("Aula N10", "Bagno", "est")
				.addAdiacenza("Bagno", "Aula N10", "ovest")
				.addStanzaMagica("Cripta", 1)
				.addAdiacenza("Cripta", "Sgabuzzino", "est")
				.addAdiacenza("Sgabuzzino", "Cripta", "ovest")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		
	}

	
}