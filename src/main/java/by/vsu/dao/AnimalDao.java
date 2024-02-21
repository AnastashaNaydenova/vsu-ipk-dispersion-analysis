package by.vsu.dao;

import by.vsu.domain.Animal;

import java.sql.*;
import java.util.*;

public class AnimalDao {
	public static List<Animal> readAll() throws SQLException, ClassNotFoundException {
		String sql = "SELECT \"id\", \"name\" FROM \"animal\"";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			List<Animal> animals = new ArrayList<>();
			while(resultSet.next()) {
				Animal animal = new Animal();
				animal.setId(resultSet.getInt("id"));
				animal.setName(resultSet.getString("name"));
				animals.add(animal);
			}
			return animals;
		} finally {
			try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static Animal read(Integer id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT \"id\", \"name\" FROM \"animal\" WHERE \"id\" = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			Animal animal = null;
			if(resultSet.next()) {
				animal = new Animal();
				animal.setId(resultSet.getInt("id"));
				animal.setName(resultSet.getString("name"));
			}
			return animal;
		} finally {
			try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void create(Animal animal) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO \"animal\"(\"name\") VALUES (?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, animal.getName());
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}


	public static void update(Animal animal) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE \"animal\" SET \"name\" = ? WHERE \"id\" = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, animal.getName());
			statement.setInt(2, animal.getId());
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void delete(Integer id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM \"animal\" WHERE \"id\" = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}
}
