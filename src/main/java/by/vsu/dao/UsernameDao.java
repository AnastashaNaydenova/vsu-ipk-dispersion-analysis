package by.vsu.dao;

import by.vsu.domain.Username;

import java.sql.*;
import java.util.*;


public class UsernameDao {
    public static List<Username> readAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT \"id\", \"firstname\" , \"surname\", \"lostname\", \"status\"," +
                " \"group\", \"login\", \"password\" FROM \"username\"";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnector.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            List<Username> usernames = new ArrayList<>();
            while (resultSet.next()) {
                Username username = new Username();
                username.setId(resultSet.getInt("id"));
                username.setFirstname(resultSet.getString("firstname"));
                username.setSurname(resultSet.getString("surname"));
                username.setLostname(resultSet.getString("lostname"));
                username.setStatus(resultSet.getString("status"));
                username.setGroup(resultSet.getInt("group"));
                username.setLogin(resultSet.getString("login"));
                username.setPassword(resultSet.getString("password"));
                usernames.add(username);
            }
            return usernames;
        } finally {
            try {Objects.requireNonNull(resultSet).close();} catch (Exception ignored) {}
            try {Objects.requireNonNull(statement).close();} catch (Exception ignored) {}
            try {Objects.requireNonNull(connection).close();} catch (Exception ignored) {}
        }
    }

    public static Username read(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT \"id\", \"firstname\" , \"surname\", \"lostname\", \"status\", " +
                "\"group\", \"login\", \"password\" FROM \"username\" WHERE \"id\" = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnector.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Username username = null;
            if(resultSet.next()) {
                username = new Username();
                username.setId(resultSet.getInt("id"));
                username.setFirstname(resultSet.getString("firstname"));
                username.setSurname(resultSet.getString("surname"));
                username.setLostname(resultSet.getString("lostname"));
                username.setStatus(resultSet.getString("status"));
                username.setGroup(resultSet.getInt("group"));
                username.setLogin(resultSet.getString("login"));
                username.setPassword(resultSet.getString("password"));
            }
            return username;
        } finally {
            try { Objects.requireNonNull(resultSet).close(); } catch(Exception ignored) {}
            try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
            try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
        }
    }

    public static Username readByLoginAndPassword(String login, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT \"id\", \"firstname\" , \"surname\", \"lostname\", \"status\", " +
                "\"group\", \"login\", \"password\" FROM \"username\" WHERE \"login\" = ? AND \"password\" = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnector.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            Username username = null;
            if(resultSet.next()) {
                username = new Username();
                username.setId(resultSet.getInt("id"));
                username.setFirstname(resultSet.getString("firstname"));
                username.setSurname(resultSet.getString("surname"));
                username.setLostname(resultSet.getString("lostname"));
                username.setStatus(resultSet.getString("status"));
                username.setGroup(resultSet.getInt("group"));
                username.setLogin(resultSet.getString("login"));
                username.setPassword(resultSet.getString("password"));
            }
            return username;
        } finally{
            try {Objects.requireNonNull(resultSet).close();} catch (Exception ignored) {}
            try {Objects.requireNonNull(statement).close();} catch (Exception ignored) {}
            try {Objects.requireNonNull(connection).close();} catch (Exception ignored) {}
        }
     }

    public static void create(Username username) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO \"username\"(\"firstname\" , \"surname\", \"lostname\" ," +
                " \"status\" , \"group\" , \"login\" , \"password\") VALUES (?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DatabaseConnector.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, username.getFirstname());
            statement.setString(2, username.getSurname());
            statement.setString(3, username.getLostname());
            statement.setString(4, username.getStatus());
            statement.setInt(5, username.getGroup());
            statement.setString(6, username.getLogin());
            statement.setString(7, username.getPassword());
            statement.executeUpdate();
        } finally {
            try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
            try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
        }
    }

    public static void update(Username username) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE \"username\" SET \"firstname\" = ?, \"surname\" = ?, \"lostname\" = ?, \"status\"= ?, " +
                "\"group\" = ?, \"login\" = ?, \"password\" = ? WHERE \"id\" = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DatabaseConnector.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, username.getFirstname());
            statement.setString(2, username.getSurname());
            statement.setString(3, username.getLostname());
            statement.setString(4, username.getStatus());
            statement.setInt(5, username.getGroup());
            statement.setString(6, username.getLogin());
            statement.setString(7, username.getPassword());
            statement.setInt(8, username.getId());
            statement.executeUpdate();
        } finally {
            try { Objects.requireNonNull(statement).close(); } catch(Exception ignored) {}
            try { Objects.requireNonNull(connection).close(); } catch(Exception ignored) {}
        }
    }

    public static void delete(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM \"username\" WHERE \"id\" = ?";
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
