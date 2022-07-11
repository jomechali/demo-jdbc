package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entities.Fournisseur;

/**
 * @author Joseph
 *
 */
public interface FournisseurDao {

	/**
	 * @return
	 * @throws SQLException
	 */
	List<Fournisseur> extraire() throws SQLException;

	/**
	 * @param fournisseur
	 * @throws SQLException
	 */
	void insert(Fournisseur fournisseur) throws SQLException;

	/**
	 * @param ancienNom
	 * @param nouveauNom
	 * @return
	 * @throws SQLException
	 */
	int update(String ancienNom, String nouveauNom) throws SQLException;

	/**
	 * @param fournisseur
	 * @return
	 * @throws SQLException
	 */
	boolean delete(Fournisseur fournisseur) throws SQLException;

}