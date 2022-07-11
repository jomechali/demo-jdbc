package fr.diginamic.jdbc;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.PersistenceManager;
import fr.diginamic.jdbc.entities.Fournisseur;

public class TestDelete {

	public static void main(String[] args) {

		Fournisseur fournisseurToDelete = new Fournisseur(4, "La Maison des Peintures");

		FournisseurDao fournisseurDao = PersistenceManager.getFournisseurDao();
		
		try {

			System.out.println(fournisseurDao.delete(fournisseurToDelete));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				PersistenceManager.freeResources();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
