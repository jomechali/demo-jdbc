package fr.diginamic.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.PersistenceManager;
import fr.diginamic.jdbc.entities.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {

		List<Fournisseur> fournisseurs = new ArrayList<>();
		
		try {
			fournisseurs = PersistenceManager.getFournisseurDao().extraire();
			for (Fournisseur fournisseur : fournisseurs) {
				System.out.println(fournisseur);
			}
			
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		finally {
			try {
				PersistenceManager.freeResources();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
