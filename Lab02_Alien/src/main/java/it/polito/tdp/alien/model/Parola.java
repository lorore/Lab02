package it.polito.tdp.alien.model;

import java.util.HashSet;
import java.util.Set;

public class Parola {

	private String parolaA;
	private Set<String> traduzioni;
	
	public Parola(String parolaA) {
		this.parolaA=parolaA;
		traduzioni=new HashSet<String>();
	}
	
	public void aggiungiTraduzione(String parolaU) {
		traduzioni.add(parolaU);
	}
}
