package by.vsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	private static boolean loaded = false;
	private static void init() throws ClassNotFoundException {
		if(!loaded) {
			Class.forName("org.postgresql.Driver");
			loaded = true;
		}
	}
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		init();
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/vida_db", "root", "root");
	}
}
