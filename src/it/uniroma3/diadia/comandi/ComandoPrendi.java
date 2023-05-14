package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	private final static String NOME = "prendi";
	String nomeAttrezzo;
	IO inOut = new IOConsole();
	String parametro;
	


	@Override
	public void esegui(Partita partita) {
		boolean noAttrezzi = false;
		if(nomeAttrezzo==null) {
			if(!partita.getStanzaCorrente().getAttrezzi().isEmpty()) {
				inOut.mostraMessaggio("Quale attrezzo vuoi prendere?");
				inOut.mostraMessaggio(partita.getStanzaCorrente().toStringAttrezzi());
				noAttrezzi = true;

			}else {
				inOut.mostraMessaggio("Non ci sono attrezzi nella stanza");
				
			}
			}
		
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)){
			
			Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if(partita.getGiocatore().getBorsa().contrPeso(attrezzo)) {
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				partita.getStanzaCorrente().removeAttrezzo(attrezzo);

				inOut.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
				
			}else {
				inOut.mostraMessaggio("La borsa è troppo piena.");
			} 
		}else if(!noAttrezzi) {
			inOut.mostraMessaggio("L'attrezzo non è presente nella stanza.");
		}
		
	}
	

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
		
	}
	

}
