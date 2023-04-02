package it.uniroma3.diadia.giocatore;

public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	private int cfu;

	Borsa borsa;
	
	public Giocatore() {
		this.borsa = new Borsa();
		this.cfu = CFU_INIZIALI;
	}

	public Borsa getBorsa() {
		return borsa;
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	




}
