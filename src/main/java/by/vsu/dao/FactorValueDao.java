package by.vsu.dao;
import by.vsu.domain.Factor;
import by.vsu.domain.FactorValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class FactorValueDao {
	public static List<FactorValue> readByFactor(Integer factorId)throws SQLException, ClassNotFoundException {
			String sql = "SELECT \"id\", \"name\", \"factor_id\" FROM \"factor_value\" WHERE \"factor_id\" = ? ";
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {
				connection = DatabaseConnector.getConnection();
				statement = connection.prepareStatement(sql);
				statement.setInt(1, factorId);
				resultSet = statement.executeQuery();
				List<FactorValue> values = new ArrayList<>();
				while(resultSet.next()) {
					FactorValue value = new FactorValue();
					value.setId(resultSet.getInt("id"));
					value.setName(resultSet.getString("name"));
					Factor factor = new Factor();
					factor.setId(resultSet.getInt("factor_id"));
					value.setFactor(factor);
					values.add(value);
				}
				return values;
			} finally {
				try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
				try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
				try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
			}
	}

	public static FactorValue read(Integer id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT \"id\", \"factor_id\", \"name\" FROM \"factor_value\" WHERE \"id\" = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			FactorValue value = null;
			if(resultSet.next()) {
				value = new FactorValue();
				value.setId(resultSet.getInt("id"));
				value.setName(resultSet.getString("name"));
				value.setFactor(new Factor());
				value.getFactor().setId(resultSet.getInt("factor_id"));
			}
			return value;
		} finally {
			try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}

	}

	public static void create(FactorValue value) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO \"factor_value\"(\"factor_id\", \"name\") VALUES (?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, value.getFactor().getId());
			statement.setString(2, value.getName());
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void update(FactorValue value) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE \"factor_value\" SET \"factor_id\" = ?, \"name\" = ? WHERE \"id\" = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatabaseConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, value.getFactor().getId());
			statement.setString(2, value.getName());
			statement.setInt(3, value.getId());
			statement.executeUpdate();
		} finally {
			try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
			try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
		}
	}

	public static void delete(Integer id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM \"factor_value\" WHERE \"id\" = ?";
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
