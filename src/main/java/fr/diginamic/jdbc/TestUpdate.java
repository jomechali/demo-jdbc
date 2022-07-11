package fr.diginamic.jdbc;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.dao.PersistenceManager;

public class TestUpdate {

	public static void main(String[] args) {

		FournisseurDao fournisseurDao = PersistenceManager.getFournisseurDao();
		
		try {
			fournisseurDao.update("La Maison de la Peinture", "La Maison des Peintures");
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
