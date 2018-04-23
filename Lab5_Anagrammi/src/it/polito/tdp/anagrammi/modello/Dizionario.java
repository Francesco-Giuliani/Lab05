package it.polito.tdp.anagrammi.modello;

import java.util.ArrayList;
import java.util.List;
import it.polito.tdp.anagrammi.DAO.*;

public class Dizionario {

	private List<String> dizionario;
	private DizionarioDAO dizionarioDAO;

	//CONSTRUCTOR
	public Dizionario() {
		this.dizionarioDAO = new DizionarioDAO();
		this.dizionario = new ArrayList<>(this.dizionarioDAO.getDizionario());
	}
	
	//METODI VARI
	public boolean contains(String parola) {		
		//FACCIO LAVORARE IL DATABASE
		
		return this.dizionarioDAO.contieneParola(parola);
	}


	//UTILITIES
	
	
	//GETTER E SETTER
	public List<String> getDizionario() {
		return dizionario;
	}

	public void caricaDizionarioDB() {
		this.dizionario = dizionarioDAO.getDizionario();
	}
	
	
	
}
