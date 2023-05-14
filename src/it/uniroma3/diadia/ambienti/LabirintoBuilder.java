package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder{

	private Labirinto lab;
	private Map<String, Stanza> nomeStanza;
	private Stanza stanzaIniziale;
	private Stanza ultimaStanza;
	
	public LabirintoBuilder() {
		this.lab = new Labirinto();
		this.nomeStanza = new HashMap<String, Stanza>();
	}
	
	public Labirinto getLabirinto() {
		return this.lab;
	}
	
	public void setEntrata2() {
		this.lab.setEntrata(this.stanzaIniziale);
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza s = new Stanza(stanzaIniziale);
		this.lab.setStanzaCorrente(s);
		this.aggiungiStanzaMap(s);
		this.stanzaIniziale = s;
		this.ultimaStanza = s;
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza v = new Stanza(stanzaVincente);
		this.lab.setStanzaVincente(v);
		this.aggiungiStanzaMap(v);
		this.ultimaStanza = v;
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo a = new Attrezzo(attrezzo, peso);
		this.ultimaStanza.addAttrezzo(a);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, String direzione) {
		Stanza c = this.nomeStanza.get(stanzaCorrente);
		Stanza d = this.nomeStanza.get(stanzaAdiacente);
		c.impostaStanzaAdiacente(direzione, d);
		return this;
	}
	
	
	public LabirintoBuilder addStanza(String stanza) {
		Stanza st = new Stanza(stanza);
		this.aggiungiStanzaMap(st);
		this.ultimaStanza = st;
		return this;
	}
	
	
	public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
		Stanza m = new StanzaMagica(nome);
		this.aggiungiStanzaMap(m);
		this.ultimaStanza = m;
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome, String dirBloccata, String attrezzoSblocco) {
		Stanza b = new StanzaBloccata(nome,dirBloccata, attrezzoSblocco);
		this.aggiungiStanzaMap(b);
		this.ultimaStanza = b;
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nome, String attrLuce) {
		Stanza bu = new StanzaBuia(nome, attrLuce);
		this.aggiungiStanzaMap(bu);
		this.ultimaStanza = bu;
		return this;
	}
	
	public void aggiungiStanzaMap(Stanza stanza) {
		this.nomeStanza.put(stanza.getNome(), stanza);
	}

	public Map<String, Stanza> getListaStanze() {
		return this.nomeStanza;
	}
	
	
	
	
	
	
}
