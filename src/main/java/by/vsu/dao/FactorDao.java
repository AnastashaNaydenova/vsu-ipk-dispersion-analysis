package by.vsu.dao;

import by.vsu.domain.Animal;
import by.vsu.domain.Factor;

import java.sql.*;
import java.util.*;

public class FactorDao {
	public static List<Factor> readByAnimal(Integer animalId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT \"id\", \"name\", \"animal_id\" FROM \"factor\" WHERE \"animal_id\" = ? ";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnector.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, animalId);
            resultSet = statement.executeQuery();
            List<Factor> factors = new ArrayList<>();
            while(resultSet.next()) {
                Factor factor = new Factor();
                factor.setId(resultSet.getInt("id"));
                Animal animal = new Animal();
                animal.setId(resultSet.getInt("animal_id"));
                factor.setAnimal(animal);
                factor.setName(resultSet.getString("name"));
                factors.add(factor);
            }
            for(Factor factor : factors) {
                factor.setValues(FactorValueDao.readByFactor(factor.getId()));
            }
            return factors;
        } finally {
            try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
            try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
            try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
        }
	}

	public static Factor read(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT \"id\", \"animal_id\", \"name\" FROM \"factor\" WHERE \"id\" = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnector.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Factor factor = null;
            if(resultSet.next()) {
                factor = new Factor();
                factor.setId(resultSet.getInt("id"));
                factor.setName(resultSet.getString("name"));
                factor.setAnimal(new Animal());
                factor.getAnimal().setId(resultSet.getInt("animal_id"));
                factor.setValues(FactorValueDao.readByFactor(factor.getId()));
            }
            return factor;
        } finally {
            try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
            try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
            try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
        }
	}

	public static void create(Factor factor) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO \"factor\"(\"animal_id\", \"name\") VALUES (?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, factor.getAnimal().getId());
			statement.setString(2, factor.getName());
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void update(Factor factor) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE \"factor\" SET \"animal_id\" = ?, \"name\" = ? WHERE \"id\" = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, factor.getAnimal().getId());
			statement.setString(2, factor.getName());
            statement.setInt(3, factor.getId());
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void delete(Integer id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM \"factor\" WHERE \"id\" = ?";
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
