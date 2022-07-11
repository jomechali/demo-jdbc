package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entities.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	@Override
	public List<Fournisseur> extraire() throws SQLException {
		List<Fournisseur> fournisseurs = new ArrayList<>();

		Connection connection = PersistenceManager.getConnection();

		try (Statement statement = connection.createStatement();
				ResultSet cursor = statement.executeQuery("SELECT * FROM FOURNISSEUR")) {

			while (cursor.next()) {
				fournisseurs.add(new Fournisseur(cursor.getInt(1), cursor.getString(2)));
			}

		}
		return fournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate("INSERT INTO FOURNISSEUR(ID, NOM) VALUES ('%d', '%s')"
					.formatted(fournisseur.getId(), fournisseur.getNom()));
		}

	}

	@Override
	public int update(String ancienNom, String nouveauNom) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		int modifiedLines = 0;
		
		try (Statement statement = connection.createStatement()) {
			modifiedLines = statement.executeUpdate(
					"UPDATE FOURNISSEUR SET NOM = '%s' WHERE NOM = '%s'".formatted(nouveauNom, ancienNom));

		}
		return modifiedLines;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate("DELETE FROM FOURNISSEUR WHERE NOM = '%s' AND ID = '%d'"
					.formatted(fournisseur.getNom(), fournisseur.getId()));
		}
		return true;
	}

}
