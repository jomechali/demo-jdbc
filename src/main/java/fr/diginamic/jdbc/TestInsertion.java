package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

	
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

		try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				Statement statement = connection.createStatement()){
			int modifiedLines = statement.executeUpdate("INSERT INTO FOURNISSEUR(ID, NOM) VALUES (4, 'La Maison des Peintures')");
			System.out.println(modifiedLines);
		} catch (SQLException  e) {
			e.printStackTrace();
		}
	}

}
