package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public Attrezzo[] attrezzi;
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private int pesoMax;
	public int numeroAttrezzi;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);

	}



	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	public boolean contrPeso(Attrezzo attrezzo) {
		if(this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			return false;
		}else {
			return true;
		}
	}


	public int getPesoMax() {
		return pesoMax;
	}


	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}


	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}


	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}


	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (int i = 0; i<this.numeroAttrezzi; i++) {
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}


	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		
		Attrezzo a = new Attrezzo();

		if(hasAttrezzo(nomeAttrezzo)) {
			for(int i=0; i< this.numeroAttrezzi; i++) {
				if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
					if(i==this.attrezzi.length) {
						numeroAttrezzi--;
					}
					else {
						for(int j=i; j<this.numeroAttrezzi; j++) {
							this.attrezzi[j] = this.attrezzi[j+1];
						}
						numeroAttrezzi--;
					}
				}
				a.setNome(nomeAttrezzo);
			}
		}
		return a;	
	}


	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++) {

				if(attrezzi[i+1]==null) {
					s.append(attrezzi[i].toString());
				}
				else{
					s.append(attrezzi[i].toString()+ " | ");
				}   
			}

		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}





