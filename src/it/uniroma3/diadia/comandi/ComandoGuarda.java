package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;


public class ComandoGuarda implements Comando {
	
	private final static String NOME = "guarda";
	IO inOut = new IOConsole();
	
	public ComandoGuarda() {
		
	}
	

	@Override
	public void esegui(Partita partita) {
		inOut.mostraMessaggio(partita.getStanzaCorrente().getDescrizione().toString());
		inOut.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		inOut.mostraMessaggio("Numero cfu: " + partita.getGiocatore().getCfu());

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		return NOME;
		
	}

	@Override
	public String getParametro() {
		return null;

	}

}
