package it.aula1.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtil {
	private static Connection connection;
	private static String url = "jdbc:derby:target\\DB;create=true";
	private static String user = "test";
	private static String password = "test";

	public static Connection getConnection() {

		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(true);
				return connection;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
