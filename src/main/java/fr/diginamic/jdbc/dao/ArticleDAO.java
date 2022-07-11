/**
 * 
 */
package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entities.Article;

/**
 * @author Joseph
 *
 */
public interface ArticleDAO {

	List<Article> extraire() throws SQLException;
	
	void inserer(Article article) throws SQLException;
	
	int update(Article ancienArticle, Article nouveArticle) throws SQLException;
	
	boolean delete(Article article) throws SQLException;
}
