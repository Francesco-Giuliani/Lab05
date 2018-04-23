package it.polito.tdp.anagrammi.modello;

import java.util.LinkedList;
import java.util.List;

public class Anagramma {
	
	List<Character> anagramma;
	List<Character> disponibili;
	
	public Anagramma(List<Character> listaCaratteriParola) {
		this.anagramma = new LinkedList<>();
		this.disponibili = new LinkedList<>(listaCaratteriParola);
	}
	
	public Anagramma(Anagramma altro) {
		this.anagramma = new LinkedList<>(altro.anagramma);
		this.disponibili = new LinkedList<>(altro.disponibili);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Character c : this.anagramma)
			sb.append(c);
		return sb.toString();
	}
	public List<Character> getAnagramma() {
		return anagramma;
	}
	
	public void add(Character c) {
		this.anagramma.add(c);
		this.disponibili.remove(c);
	}
	public void removeLast() {
		Character c = this.anagramma.get(this.anagramma.size()-1);
		this.disponibili.add(c);
		this.anagramma.remove(this.anagramma.size()-1);
	}

	public List<Character> getDisponibili() {
		return this.disponibili;
	}
	
}
