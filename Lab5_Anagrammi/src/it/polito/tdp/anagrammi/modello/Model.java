package it.polito.tdp.anagrammi.modello;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.*;

public class Model {

	private String parolaDaAnagrammare;
	private int lunghezzaParolaDaAnagrammare;
	private Dizionario dizionario;
	private List<Character> listaCaratteriParola;
	private List<Anagramma> anagrammiCorretti;
	private List<Anagramma> anagrammiErrati;
	private List<Anagramma> anagrammiParziali;
	
	//CONSTRUCTOR
	public Model() {
		this.dizionario = new Dizionario();
		this.anagrammiCorretti = new ArrayList<>();
		this.anagrammiErrati = new ArrayList<>();
		this.anagrammiParziali = new ArrayList<>();
	}
	
	//TODO METODI VARI
	
	public void generaAnagrammi(String parola) {
		this.parolaDaAnagrammare = this.formattaStringa(parola);
		this.lunghezzaParolaDaAnagrammare = this.parolaDaAnagrammare.length();
		this.listaCaratteriParola = this.stringaToCharacterList(this.parolaDaAnagrammare);
		
		System.out.println("Lista carateri: "+this.listaCaratteriParola.toString()+" Lunghezza: "+this.lunghezzaParolaDaAnagrammare);
		
		Anagramma anagramma = new Anagramma(this.listaCaratteriParola);
		int livello = 0; //DOVE IL LIVELLO RAPPRESENTA il numero di caratteri aggiunti all'anagramma
		System.out.println(anagramma.getDisponibili().toString());
		this.recursive(livello, anagramma);
	}
	
	public void recursive(int livello, Anagramma parziale) {
		
		//System.out.println("parz. prima di aggiunta char:" +parziale);
		
		//CONDIZIONE DI TERMINAZIONE
		if(livello >= this.lunghezzaParolaDaAnagrammare) {
			if(this.dizionario.contains(parziale.toString())) {
				System.out.println("terminazione: anagramma corretto "+parziale+". Livello = "+livello);
				this.anagrammiCorretti.add(new Anagramma(parziale));
			}
			else {
				System.out.println("terminazione: anagramma errato. Livello = "+livello);
				this.anagrammiErrati.add(new Anagramma(parziale));
			}
			return;
		}
		//NUOVA SOLUZIONE PARZIALE
		List<Character> charDisponibili = new ArrayList<>(parziale.getDisponibili());
		
		for(Character c : charDisponibili) {
			parziale.add(c);
			this.anagrammiParziali.add(new Anagramma(parziale));
			recursive(livello+1, parziale);
			parziale.removeLast();
		}
		return;
	}
	
	public String formattaStringa(String parola) {
		String risultato = parola.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		risultato = risultato.replaceAll("\\?", "");
		risultato = risultato.replaceAll("\n\r\t", "");
		
		return risultato.toLowerCase();
	}
	
	
	//GETTERS E SETTER
	
	
	public String getParolaDaAnagrammare() {
		return parolaDaAnagrammare;
	}

	public List<Anagramma> getAnagrammiCorretti() {
		return anagrammiCorretti;
	}

	public List<Anagramma> getAnagrammiErrati() {
		return anagrammiErrati;
	}

//	public void setParolaDaAnagrammare(String parolaDaAnagrammare) {
//		this.parolaDaAnagrammare = parolaDaAnagrammare;
//		this.listaCaratteriParola = new ArrayList<>(this.stringaToCharacterList(this.parolaDaAnagrammare));
//	}

	public Dizionario getDizionario() {
		return dizionario;
	}

	public void setDizionario(Dizionario dizionario) {
		this.dizionario = dizionario;
	}
	public List<Character> stringaToCharacterList(String parola){
		char[] arrParola = parola.toCharArray();
		List<Character> risultato = new LinkedList<>();
		for(char c: arrParola) {
			risultato.add((Character)c);
		}
		
		return risultato;
	}
	
	public List<Anagramma> getAnagrammiParziali(){
		return this.anagrammiParziali;
	}

}
