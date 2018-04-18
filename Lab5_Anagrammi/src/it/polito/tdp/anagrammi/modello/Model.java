package it.polito.tdp.anagrammi.modello;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.*;

public class Model {

	private String parolaDaAnagrammare;
	private Dizionario dizionario;
	private List<Anagramma> anagrammiCorretti;
	private List<Anagramma> anagrammiErrati;
	
	//CONSTRUCTOR
	public Model() {
		this.dizionario = new Dizionario();
	}
	
	//TODO METODI VARI
	
	public void generaAnagrammi(String parola) {
		
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

	public void setParolaDaAnagrammare(String parolaDaAnagrammare) {
		this.parolaDaAnagrammare = parolaDaAnagrammare;
	}

	public Dizionario getDizionario() {
		return dizionario;
	}

	public void setDizionario(Dizionario dizionario) {
		this.dizionario = dizionario;
	}
	public List<Character> stringaToLetteraList(String parola){
		Character[] arrParola = parola.toCharArray();
		
		List<Character> risultato = new LinkedList<>();
		
	}
		
}
