/**
 * 
 */
package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.diginamic.jdbc.entities.Article;
import fr.diginamic.jdbc.entities.Fournisseur;

/**
 * @author Joseph
 *
 */
public class ArticleDAOJDBC implements ArticleDAO {

	private static final String FIND_ALL_QUERY = "SELECT * FROM ARTICLE";
	private static final String INSERT_QUERY = "INSERT INTO ARTICLE(ID, REF, DESIGNATION, PRIX, ID_FOU) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE_QUERY = "UPDATE ARTICLE SET ID = ?, REF = ?, DESIGNATION = ?, PRIX = ?, ID_FOU = ? WHERE ID = ?";
	private static final String DELETE_QUERY = "DELETE FROM ARTICLE WHERE ID = ?";

	@Override
	public List<Article> extraire() throws SQLException {
		Connection connection = PersistenceManager.getConnection();
		List<Fournisseur> fournisseurs = PersistenceManager.getFournisseurDao().extraire();

		List<Article> articles = new ArrayList<>();

		try (PreparedStatement pst = connection.prepareStatement(FIND_ALL_QUERY)) {

			ResultSet resultset = pst.executeQuery();

			while (resultset.next()) {

				int requeredFournisseurId = resultset.getInt(5);

				Optional<Fournisseur> optionalFournisseur = fournisseurs.stream()
						.filter(f -> f.getId() == requeredFournisseurId).findAny();

				// TODO what should be done when there is no fournisseur?
				articles.add(new Article(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
						resultset.getFloat(4), optionalFournisseur.get()));

			}
		}
		return articles;
	}

	@Override
	public void inserer(Article article) throws SQLException {

		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement pst = connection.prepareStatement(INSERT_QUERY)) {
			pst.setInt(1, article.getId());
			pst.setString(2, article.getRef());
			pst.setString(3, article.getDesignation());
			pst.setFloat(4, article.getPrix());
			pst.setInt(5, article.getFournisseur().getId());
		}
	}

	@Override
	public int update(Article ancienArticle, Article nouveArticle) throws SQLException {
		int modifiedLines = 0;
		Connection connection = PersistenceManager.getConnection();

		// "UPDATE ARTICLE SET ID = ?, REF = ?, DESIGNATION = ?, PRIX = ?, ID_FOU = ?
		// WHERE ID = ?"
		try (PreparedStatement pst = connection.prepareStatement(UPDATE_QUERY)) {
			pst.setInt(1, nouveArticle.getId());
			pst.setString(2, nouveArticle.getRef());
			pst.setString(3, nouveArticle.getDesignation());
			pst.setFloat(4, nouveArticle.getPrix());
			pst.setInt(5, nouveArticle.getFournisseur().getId());

			pst.setInt(6, ancienArticle.getId());

			pst.executeUpdate();
		}
		return modifiedLines;
	}

	@Override
	public boolean delete(Article article) throws SQLException {
		Connection connection = PersistenceManager.getConnection();

		try (PreparedStatement pst = connection.prepareStatement(DELETE_QUERY)) {
			// "DELETE FROM ARTICLE WHERE ID = ?"
			pst.setInt(1, article.getId());
			pst.executeUpdate();

		}
		return true;
	}

}
