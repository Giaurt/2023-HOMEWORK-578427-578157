package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String attrezzoLuce;
	
	public StanzaBuia(String nome, String attrezzoLuce) {
		super(nome);
		this.attrezzoLuce = attrezzoLuce;
	}
	
	@Override
	public String getDescrizione() {
		String buio = new String();
		buio = "Qui c'è buio pesto";
		if(!this.hasAttrezzo(attrezzoLuce)) {
			return buio;
		}
		return super.getDescrizione();
		
			
	}
		
}


