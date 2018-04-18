package it.polito.tdp.anagrammi.modello;

import java.util.List;
import it.polito.tdp.anagrammi.DAO.*;

public class Dizionario {

	private List<String> dizionario;
	private DizionarioDAO dizionarioDAO;

	//CONSTRUCTOR
	public Dizionario() {
		this.dizionarioDAO = new DizionarioDAO();
	}
	
	//METODI VARI
//	public boolean isInDizionario(String parola) {
//		
//		// OPZIONE 1 FACCIO IN QUESTA CLASSE --> lavora java
////		for(String s: this.dizionario) {
////			if(s.compareTo(parola)==0)
////				return true;
////		}
////		return false;
////		
//		//OPZIONE 2 FACCIO LAVORARE IL DATABASE
//		
//		 return this.dizionarioDAO.contieneParola(parola);
//	}
//	

	//UTILITIES
	
	
	//GETTER E SETTER
	public List<String> getDizionario() {
		return dizionario;
	}

	public void caricaDizionarioDB() {
		this.dizionario = dizionarioDAO.getDizionario();
	}
	
	
	
}
