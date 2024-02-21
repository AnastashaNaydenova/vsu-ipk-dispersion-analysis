package by.vsu.dao;

import by.vsu.domain.Animal;
import by.vsu.domain.Property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PropertyDao {
	public static List<Property> readByAnimal(Integer animalId) throws SQLException, ClassNotFoundException{
		String sql = "SELECT \"id\", \"name\", \"animal_id\" FROM \"property\" WHERE \"animal_id\" = ? ";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, animalId);
			resultSet = statement.executeQuery();
			List<Property> properties = new ArrayList<>();
			while(resultSet.next()) {
				Property property = new Property();
				property.setId(resultSet.getInt("id"));
				property.setName(resultSet.getString("name"));

				Animal animal = new Animal();
				animal.setId(resultSet.getInt("animal_id"));
				property.setAnimal(animal);

				properties.add(property);
			}
			return properties;
		} finally {
			try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static Property read(Integer id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT \"id\", \"animal_id\", \"name\" FROM \"property\" WHERE \"id\" = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			Property property = null;
			if(resultSet.next()) {
				property = new Property();
				property.setId(resultSet.getInt("id"));
				property.setName(resultSet.getString("name"));
				property.setAnimal(new Animal());
				property.getAnimal().setId(resultSet.getInt("animal_id"));
			}
			return property;
		} finally {
			try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}

	}

	public static void create(Property property) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO \"property\"(\"animal_id\" , \"name\") VALUES (?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, property.getAnimal().getId());
			statement.setString(2, property.getName());
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void update( Property property) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE \"property\" SET \"animal_id\" = ?, \"name\" = ? WHERE \"id\" = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, property.getAnimal().getId());
			statement.setString(2, property.getName());
			statement.setInt(3, property.getId());
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void delete(Integer id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM \"property\" WHERE \"id\" = ?";
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
