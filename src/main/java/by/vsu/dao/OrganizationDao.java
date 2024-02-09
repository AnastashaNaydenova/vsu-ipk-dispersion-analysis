package by.vsu.dao;

import by.vsu.domain.Organization;

import java.sql.*;
import java.util.*;

public class OrganizationDao {
	public static List<Organization> readAll() throws SQLException, ClassNotFoundException {
		String sql = "SELECT \"id\", \"name\" , \"individual\", \"area\" FROM \"organization\"";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			List<Organization> organizations = new ArrayList<>();
			while(resultSet.next()) {
				Organization organization = new Organization();
				organization.setId(resultSet.getInt("id"));
				organization.setName(resultSet.getString("name"));
				organization.setIndividual(resultSet.getBoolean("individual"));
				organization.setArea(resultSet.getDouble("area"));
				organizations.add(organization);
			}
			return organizations;
		} finally {
			try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static Organization read(Integer id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT \"id\", \"name\" , \"individual\", \"area\" FROM \"organization\" WHERE \"id\" = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			Organization organization = null;
			if(resultSet.next()) {
				organization = new Organization();
				organization.setId(resultSet.getInt("id"));
				organization.setName(resultSet.getString("name"));
				organization.setIndividual(resultSet.getBoolean("individual"));
				organization.setArea(resultSet.getDouble("area"));
			}
			return organization;
		} finally {
			try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void create(Organization organization) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO \"organization\"(\"name\" , \"individual\", \"area\") VALUES (?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, organization.getName());
			statement.setBoolean(2, organization.isIndividual());
			statement.setDouble(3, organization.getArea());
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void update(Organization organization) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE \"organization\" SET \"name\" = ?, \"individual\" = ?, \"area\" = ? WHERE \"id\" = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, organization.getName());
			statement.setBoolean(2, organization.isIndividual());
			statement.setDouble(3, organization.getArea());
			statement.setInt(4, organization.getId());
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void delete(Integer id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM \"organization\" WHERE \"id\" = ?";
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
