package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translations;
	
	public WordEnhanced(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translations.add(translation);
	}
	
	public WordEnhanced(String alienWord) {
		super();
		this.alienWord = alienWord;
		this.translations=new ArrayList<String>();
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		String s="";
		
		for(String t: translations) {
			s+=t+"\n";
		}
		return s;
	}

	public void setTranslation(String translation) {
		if(!translations.contains(translation)) {
			translations.add(translation);
			
		}
	}

	public boolean compareWild(String alienWord2) {
		if(alienWord.matches(alienWord2))
			return true;
		return false;
	}
	
	
	

}
