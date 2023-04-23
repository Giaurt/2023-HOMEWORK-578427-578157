package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	private final static String NOME = "fine";
	IO inOut = new IOConsole();
	
	public ComandoFine() {
		
	}

	@Override
	public void esegui(Partita partita) {
		inOut.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		System.exit(1); 

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
