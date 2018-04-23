package it.polito.tdp.anagrammi.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DizionarioDAO {

	private List<String> dizionario;
	private ConnectDB connectDB;
	
	
	public DizionarioDAO() {
		
		this.dizionario = new ArrayList<>();
		String sqlQuery = "SELECT * FROM parola";

		try {
			this.connectDB = new ConnectDB();
			Connection conn= connectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sqlQuery);
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				String parola = res.getString("nome");
				this.dizionario.add(parola);
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DizionarioDAO(DizionarioDAO dizionarioDAO) {
		this.dizionario = new ArrayList<>(dizionarioDAO.getDizionario());
	}

	public boolean contieneParola(String parola) {
		
		List<String> listaParole = new ArrayList<>();
		String sqlQuery = "SELECT * FROM parola WHERE parola.nome = ?";

		try {
			this.connectDB = new ConnectDB();
			Connection conn= connectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sqlQuery);
			st.setString(1, parola);
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				String p = res.getString("nome");
				listaParole.add(p);
			}
			
			conn.close();
			if(listaParole.size()>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public List<String> getDizionario(){
		return this.dizionario;
	}

}
