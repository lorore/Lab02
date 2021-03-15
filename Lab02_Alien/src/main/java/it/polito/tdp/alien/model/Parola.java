package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Parola {

	private String parolaA;
	private Map<String, String> traduzioni;
	
	public Parola(String parolaA) {
		this.parolaA=parolaA;
		traduzioni=new TreeMap<String, String>();
	}
	
	public void aggiungiTraduzione(String parolaU) {
		if(traduzioni.containsKey(parolaU)!=true)
		traduzioni.put(parolaU, parolaU);
	}

	public Collection<String> traduci(){
		return this.traduzioni.values();
	}
	
	
}
