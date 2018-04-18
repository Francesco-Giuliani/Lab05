package it.polito.tdp.anagrammi.DAO;

import java.sql.*;
import java.util.List;

public class DizionarioDAO {

	private List<String> dizionario;
	
	//TODO 
	// 1. Connettersi al db e caricare il dizionario sulla lista per fare il check delle soluzioni date dalla
	//ricorsione
	
	// 2. Creare un metodo che interroghi direttamente il database per verificare l'esistenza della parola
	// (possibile fare un branche con le due diverse opzioni risolutive --> poi verifica prestazioni).
	
	
	
	public List<String> getDizionario(){
		return this.dizionario;
	}

	public boolean contieneParola(String parola) {
		// TODO Auto-generated method stub
		return false;
	}
}
