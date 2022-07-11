package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entities.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	private static final String FIND_ALL_QUERY = "SELECT * FROM FOURNISSEUR";
	private static final String INSERT_INTO = "INSERT INTO FOURNISSEUR(ID, NOM) VALUES (?, ?)";
	private static final String UPDATE = "UPDATE FOURNISSEUR SET NOM = ? WHERE NOM = ?";
	private static final String DELETE = "DELETE FROM FOURNISSEUR WHERE NOM = ? AND ID = ?";

	@Override
	public List<Fournisseur> extraire() throws SQLException {
		List<Fournisseur> fournisseurs = new ArrayList<>();

		Connection connection = PersistenceManager.getConnection();

		try (PreparedStatement pst = connection.prepareStatement(FIND_ALL_QUERY);
				ResultSet cursor = pst.executeQuery()) {

			while (cursor.next()) {
				fournisseurs.add(new Fournisseur(cursor.getInt(1), cursor.getString(2)));
			}

		}
		return fournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement pst = connection.prepareStatement(INSERT_INTO)) {
			pst.setInt(1, fournisseur.getId());
			pst.setString(2, fournisseur.getNom());
			pst.executeUpdate();
		}

	}

	@Override
	public int update(String ancienNom, String nouveauNom) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		int modifiedLines = 0;

		try (PreparedStatement pst = connection.prepareStatement(UPDATE)) {
			pst.setString(1, nouveauNom);
			pst.setString(2, ancienNom);

			modifiedLines = pst.executeUpdate();

		}
		return modifiedLines;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement pst = connection.prepareStatement(DELETE)) {
			pst.setString(1, fournisseur.getNom());
			pst.setInt(2, fournisseur.getId());
			pst.executeUpdate();
		}
		return true;
	}

}
