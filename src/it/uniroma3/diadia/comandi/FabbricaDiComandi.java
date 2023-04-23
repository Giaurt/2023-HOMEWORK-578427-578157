package it.uniroma3.diadia.comandi;

public interface FabbricaDiComandi extends Comando{
	
	public Comando costruisciComando(String istruzione);

}
