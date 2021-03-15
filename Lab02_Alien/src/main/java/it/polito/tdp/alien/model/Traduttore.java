package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.Map;

public class Traduttore {

	private Map<String, String> dizionario;
	
	public Traduttore() {
		dizionario=new HashMap<String, String>();
	}
	
	public void aggiungiParola(String parolaA, String parolaU) {
		dizionario.put(parolaA, parolaU);
	}
	
	public String traduci(String parolaA) {
		return dizionario.get(parolaA);
	}
	
}
