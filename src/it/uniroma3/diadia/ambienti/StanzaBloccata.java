package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	
	private String dirBloccata;
	private String attrezzoSbloccante;
	
	
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoChiave) {
		super(nome);
		this.dirBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoChiave;

	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(dirBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSbloccante)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
		
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = new String();
		bloccata = "La stanza nella direzione "+ dirBloccata +" è bloccata." + "\nPrendi -> " + attrezzoSbloccante + " e posalo nella stanza per aprire la porta.";
		
		if(!this.hasAttrezzo(attrezzoSbloccante)) {
			return bloccata;
		}
		return super.getDescrizione();
	}
	
	
	

}
