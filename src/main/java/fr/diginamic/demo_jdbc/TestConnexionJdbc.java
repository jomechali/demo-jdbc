package fr.diginamic.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionJdbc {

	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.getConnection(args[0], args[1], args[2]);

		System.out.println(connection);
		connection.close();
	}

}
