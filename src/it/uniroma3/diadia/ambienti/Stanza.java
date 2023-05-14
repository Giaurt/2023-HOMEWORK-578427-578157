package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	//static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
    //private Attrezzo[] attrezzi;
	private Map<String, Attrezzo> attrezzi;
    public int numeroAttrezzi;
    //private Stanza[] stanzeAdiacenti;
    private int numeroStanzeAdiacenti;
	private Map<String, Stanza> direzioniEStanze;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioniEStanze = new HashMap<String, Stanza>();
      //  this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        //this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
        this.attrezzi = new HashMap<String, Attrezzo>();
    }
    

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false;
    	/*for(int i=0; i<this.direzioniEStanze.size(); i++)
        	if (this.direzioni.containsKey(direzione)) {
        		this.stanzeAdiacenti[i] = stanza;
        		aggiornato = true;
        	}*/
    	if(direzioniEStanze.containsKey(direzione)) {
    		this.direzioniEStanze.put(direzione, stanza);
    		aggiornato = true;
    	}
    	if (!aggiornato)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.direzioniEStanze.put(direzione, stanza);
    		    this.numeroStanzeAdiacenti++;
    		}
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
		if(this.direzioniEStanze.containsKey(direzione)) {
			stanza = this.direzioniEStanze.get(direzione);
		}
        return stanza;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Map<String ,Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	this.attrezzi.put(attrezzo.getNome(), attrezzo);
    	return true;
        
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	/*for (String direzione : this.direzioniEStanze.values())
    		if (direzione!=null)
    			risultato.append(" " + direzione);*/
    	risultato.append(this.getDirezioni().toString());
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.attrezzi.values()) {
    		risultato.append(attrezzo+" ");
    		
    		
    	}
    	return risultato.toString();
    }
    
    
    public String toStringAttrezzi() {
    	
    	StringBuilder risultato = new StringBuilder();
    	risultato.append("Attrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.attrezzi.values()) {
    		
    		risultato.append(attrezzo+" ");
    		
    		
    	}
    	return risultato.toString();
    }
    

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		if(this.attrezzi.get(nomeAttrezzo)!= null) {
			trovato = true;
		}
		return trovato;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		/*for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}*/
		
		/*for(Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo.getNome().equals(nomeAttrezzo)) {
				return attrezzo;
			}
			}*/
		attrezzoCercato = this.attrezzi.get(nomeAttrezzo);
		if(attrezzoCercato!=null) {
			return attrezzoCercato;
		}else {
			return null;
		}
				
		
		
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		
	//	if(hasAttrezzo(attrezzo.getNome())) {
		for(Attrezzo atr : this.attrezzi.values()) {
			if(atr.getNome().equals(attrezzo.getNome())) {
				this.attrezzi.remove(attrezzo.getNome());
				return true;
			}
		}
			/*for(int i = 0; i<this.numeroAttrezzi; i++) {
				if(this.attrezzi[i].getNome().equals(attrezzo.getNome())) {
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
			}*/
			return false;
	//	}
		/*else {
			return false;
		}*/
	}


	public Set<String> getDirezioni() {
	    return this.direzioniEStanze.keySet();
    }


	public Map<String, Attrezzo> getMapStanzeAdiacenti() {
		Map<String, Attrezzo> nomeAttrezzo = new HashMap<>();
		nomeAttrezzo.put(((Stanza) this.direzioniEStanze.values()).getNome(), (Attrezzo) this.attrezzi.values());
		
		return nomeAttrezzo;
	}

}