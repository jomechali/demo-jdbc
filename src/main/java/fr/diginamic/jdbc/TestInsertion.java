package fr.diginamic.jdbc;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.PersistenceManager;
import fr.diginamic.jdbc.entities.Fournisseur;

public class TestInsertion {

	public static void main(String[] args) {

		FournisseurDao fournisseurDao = PersistenceManager.getFournisseurDao();

		try {
			fournisseurDao.insert(new Fournisseur(4, "La Maison de la Peinture"));
			fournisseurDao.insert(new Fournisseur(5, "L'Espace Création"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
