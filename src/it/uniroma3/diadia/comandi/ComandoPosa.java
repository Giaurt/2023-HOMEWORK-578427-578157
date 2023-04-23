package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private final static String NOME = "posa";
	String nomeAttrezzo;
	IO inOut = new IOConsole();
	


	@Override
	public void esegui(Partita partita) {
		boolean noAttezzo = false;
		if(nomeAttrezzo==null) {
			inOut.mostraMessaggio("Quale attrezzo vuoi posare? ");
			inOut.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
			noAttezzo = true;
			

		}if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			inOut.mostraMessaggio("Attrezzo " + attrezzo.getNome() + " posato correttamente");
		}else if(!noAttezzo){
			inOut.mostraMessaggio("L'attrezzo non è presente nella borsa.");
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
