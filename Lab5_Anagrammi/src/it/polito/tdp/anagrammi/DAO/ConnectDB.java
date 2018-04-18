package it.polito.tdp.anagrammi.DAO;

import java.sql.*;

public class ConnectDB {

	private String percorsoDB;
	private Connection conn;
	
	public ConnectDB(String percorsoDB) {
		this.percorsoDB = percorsoDB;
		
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
