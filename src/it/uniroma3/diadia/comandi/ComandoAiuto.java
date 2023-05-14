package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	private final static String NOME = "aiuto";
	IO inOut = new IOConsole();
	
	static final public String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};


	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			inOut.mostraMessaggio(elencoComandi[i]+" ");
		
	}
		
	

	@Override
	public void setParametro(String parametro) {
		
		
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
