/**
 * 
 */
package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Joseph
 *
 */
public class PersistenceManager {

	enum StoreMode {
		JDBC {
			@Override
			public FournisseurDao getFournisseurDao() {
				return new FournisseurDaoJdbc();
			}
		},
		XML {
			@Override
			public FournisseurDao getFournisseurDao() {
				// not yet implemented
				return null;
			}
		};

		public abstract FournisseurDao getFournisseurDao();
	}

	//this could be put into the enum, rather than changing names
	private static final StoreMode STORE_MODE;
	private static final String DB_URL; // db pourrait etre renommé JDBC pour que ces identifiants soient propres a
										// chaque db qu on veut utiliser
	private static final String DB_USER;
	private static final String DB_PWD;

	static {
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		DB_URL = bundle.getString("jdbc.log.URL");
		DB_USER = bundle.getString("jdbc.log.USER");
		DB_PWD = bundle.getString("jdbc.log.PWD");
		STORE_MODE = StoreMode.valueOf(bundle.getString("STORE_MODE"));

	}

	/** connection, can depend on the database type, to be renamed JDBCConnection, the same as the other attributes */
	private static Connection connection;

	/**
	 * Constructor
	 */
	private PersistenceManager() {
		super();
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
		}

		return connection;
	}

	/**
	 * @return
	 */
	public static FournisseurDao getFournisseurDao() {
		return STORE_MODE.getFournisseurDao();
	}

	/**
	 * @throws SQLException
	 */
	public static void freeResources() throws SQLException {
		if (!(connection == null && connection.isClosed())) {
			connection.close(); // should be put into the enum
		}
	}
}
