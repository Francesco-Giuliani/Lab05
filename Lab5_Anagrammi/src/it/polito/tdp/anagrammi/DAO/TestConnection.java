package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		ConnectDB connectDB = new ConnectDB();
		
		System.out.println("TEST getConnection()");
		
		Connection conn = connectDB.getConnection();
		
		System.out.println("nome DB: "+conn);
			System.out.println("nome DB: "+conn.getMetaData().getDatabaseProductName()+ ", URL: " +conn.getMetaData().getURL());
			System.out.println(conn.getSchema());
		conn.close();
		
		System.out.println("TEST carica dizionario");
		DizionarioDAO dizionarioDAO = new DizionarioDAO();
		
		List<String>dizionario = new ArrayList<>(dizionarioDAO.getDizionario());
		for(String s:dizionario)
			System.out.println(s);
	
		System.out.println("TEST cercaParola(String parola) - versione SQL");
		
		System.out.println("cerco la parola 'mucca': " + dizionarioDAO.contieneParola("mucca"));
		}

}
