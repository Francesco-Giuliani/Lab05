package it.polito.tdp.anagrammi.modello;

import java.util.LinkedList;
import java.util.List;

public class Anagramma {
	
	List<Character> parolaDipartenza;
	List<Character> disponibili;
	List<Character> anagramma;
	
	public Anagramma(List<Character> parola) {
		this.parolaDipartenza = parola;
		this.disponibili = new LinkedList<>();
		this.anagramma = new LinkedList<>();
	}
	
	public Anagramma(Anagramma altro) {
		this.parolaDipartenza = altro.parolaDipartenza;
		this.disponibili = new LinkedList<>(altro.disponibili);
		this.anagramma = new LinkedList<>(altro.anagramma);
	}

	@Override
	public String toString() {
		String risultato = null;
		for(Character l : this.anagramma)
			risultato  += l;
		return risultato;
	}
	public String toStringInfo() {
		String anagramma = null, disponibili = null ;
		for(Character l : this.anagramma)
			anagramma  += l;
		for(Character l : this.disponibili)
			disponibili  += l;
		return "anagramma: "+anagramma+", disponibili: "+disponibili;
	}
	
	
}
