package it.uniroma3.diadia;

public class IOSimulator implements IO{
	
	private String[] comandiLetti;
	private int indiceComandiLetti;
	private String[] comandi;
	private int indiceComandiInseriti;
	private int indiceComandiInviati;
	
	
	public IOSimulator(String[] righeDaLeggere) {
		this.comandiLetti = righeDaLeggere;
		this.indiceComandiLetti = 0;
		this.indiceComandiInviati = 0;
		this.comandi = new String[9999];
		
	}

	@Override
	public void mostraMessaggio(String msg) {
		this.comandi[indiceComandiInseriti] = msg;
		this.indiceComandiInseriti++;
		
	}

	@Override
	public String leggiRiga() {
		
		String riga = null;
		riga = this.comandiLetti[indiceComandiLetti];
		this.indiceComandiLetti++;
		return riga;
		
	}

}
