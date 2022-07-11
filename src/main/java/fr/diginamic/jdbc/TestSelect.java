package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entities.Fournisseur;

public class TestSelect {

	
	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;

	static {
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		DB_URL = bundle.getString("jdbc.log.URL");
		DB_USER = bundle.getString("jdbc.log.USER");
		DB_PWD = bundle.getString("jdbc.log.PWD");
	}
	
	public static void main(String[] args) {

		List<Fournisseur> fournisseurs = new ArrayList<>();
		
		try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				Statement statement = connection.createStatement();
				ResultSet cursor = statement.executeQuery("SELECT * FROM FOURNISSEUR")){
			
			while (cursor.next()) {
				fournisseurs.add(new Fournisseur(cursor.getInt(1), cursor.getString(2)));				
			}
			for (Fournisseur fournisseur : fournisseurs) {
				System.out.println(fournisseur);
			}
			
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		
	}

}
