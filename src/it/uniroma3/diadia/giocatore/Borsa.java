package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.SortPerPeso;

public class Borsa {
	private Map<String, Attrezzo> attrezzi;
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private int pesoMax;
	private int pesoAttuale;
	//public int numeroAttrezzi;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);

	}



	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>(); // speriamo bastino...
		this.pesoAttuale = 0;
		//this.numeroAttrezzi = 0;
	}
	
	public Map<String, Attrezzo> getAttrezzi(){
		return this.attrezzi;
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		pesoAttuale += attrezzo.getPeso();
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
		if(this.attrezzi.containsKey(nomeAttrezzo)) {
			a = this.attrezzi.get(nomeAttrezzo);
		}

		return a;
	}


	public int getPeso() {
		return pesoAttuale;
	}


	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}


	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		/*for (int i = 0; i<this.numeroAttrezzi; i++) {
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				trovato = true;*/
		if(this.attrezzi.containsKey(nomeAttrezzo)) {
			trovato = true;
		}
		return trovato;
	}


	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		
		Attrezzo a = new Attrezzo();

		if(hasAttrezzo(nomeAttrezzo)) {
			/*for(int i=0; i< this.numeroAttrezzi; i++) {
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
			*/}
		a = this.attrezzi.get(nomeAttrezzo);
		this.attrezzi.remove(nomeAttrezzo);
		this.pesoAttuale = this.pesoAttuale-a.getPeso();
		return a;	
		}
		


	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		/*	for (int i= 0; i<this.numeroAttrezzi; i++) {

				if(attrezzi[i+1]==null) {
					s.append(attrezzi[i].toString());
				}
				else{
					s.append(attrezzi[i].toString()+ " | ");
				}   
			}*/
			s.append(this.attrezzi.values().toString());
			s.append("\n");
			
			
			s.append(this.getContenutoOrdinatoPerNome());
			
			
			s.append("\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append("\n");
			s.append("[");
			for(int i=0; i<this.getContenutoOrdinatoPerPeso().size(); i++) {
				s.append(this.getContenutoOrdinatoPerPeso().get(i).getNome().toString());
				if(i<this.getContenutoOrdinatoPerPeso().size()-1) {
					s.append(",");
				}
			}
			s.append("]"+"\n");
			
			s.append(this.getSortedSetOrdinatoPerPeso().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new SortPerPeso());
		s.addAll(this.attrezzi.values());
		return s;
	}
	
	
	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> lista = new ArrayList<>();
		for(Attrezzo atr : this.attrezzi.values()) {
			lista.add(atr);
		}
	/*	lista.addAll(this.attrezzi.values());*/
		Collections.sort(lista, new SortPerPeso());
		return lista;
	}
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(this.getAttrezzi().values());
	}
	
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> mp = new TreeMap<>();
		
		for(Attrezzo a: this.attrezzi.values()) {
			if(mp.containsKey(a.getPeso())) {
				mp.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> s = new HashSet<Attrezzo>();
				s.add(a);
				mp.put(a.getPeso(), s);
		}
		
		}
		return mp;
	}
	
	
}


  





