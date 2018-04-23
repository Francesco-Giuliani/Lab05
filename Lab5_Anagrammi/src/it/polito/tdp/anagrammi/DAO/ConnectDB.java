package it.polito.tdp.anagrammi.DAO;

import java.sql.*;

public class ConnectDB {

	private String percorsoDB;
	private Connection conn;
	
	public ConnectDB() {
		this.percorsoDB = "jdbc:mysql://localhost:3306/dizionario?user=root";
		
		try {
			this.conn = DriverManager.getConnection(percorsoDB);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return this.conn;
	}
}
