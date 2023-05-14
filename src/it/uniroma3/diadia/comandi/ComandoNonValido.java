package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{

	private final static String NOME = "non valido";
	IO inOut = new IOConsole();
	
	public ComandoNonValido() {
		inOut.mostraMessaggio("Comando non valido.");
	}
	
	@Override
	public void esegui(Partita partita) {
		
		
		
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
