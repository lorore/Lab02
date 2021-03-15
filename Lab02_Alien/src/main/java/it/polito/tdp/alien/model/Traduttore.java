package it.polito.tdp.alien.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Traduttore {

/*	private Map<String, String> dizionario;
	
	public Traduttore() {
		dizionario=new HashMap<String, String>();
	}
	
	public void aggiungiParola(String parolaA, String parolaU) {
		dizionario.put(parolaA, parolaU);
	}
	
	public String traduci(String parolaA) {
		return dizionario.get(parolaA);
	}
	*/
	
	private TreeMap<String, Parola> dizionario;
	
	public Traduttore() {
		dizionario=new TreeMap<String, Parola>();
	}
	
	public void aggiungiParola(String parolaA, String parolaU) {
		if(dizionario.containsKey(parolaA)!=true)
			dizionario.put(parolaA, new Parola(parolaA));
			
		dizionario.get(parolaA).aggiungiTraduzione(parolaU);
		
	}
	
	public Collection<String> traduci(String parolaA){
		if(dizionario.containsKey(parolaA)) {
			return dizionario.get(parolaA).traduci();
			
		}
		return null;
	}
	
}
