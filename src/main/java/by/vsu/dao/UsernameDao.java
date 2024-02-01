package by.vsu.dao;

import by.vsu.domain.Username;

import java.sql.*;
import java.util.*;


public class UsernameDao {
    private static final Map<Integer, Username> usernames = new HashMap<>();
    static {
        usernames.put(3, build(3, "Иван", "Иванов", "Иванович", "аспирант", 4,"abc", "123" ));
        usernames.put(1, build(1, "Петр", "Петров", "Петрович", "аспирант", 5, "cba", "321"));
        usernames.put(2, build(2, "Сергей", "Сергеев", "Сергеевич", "студент", 4, "xyz", "456"));
        usernames.put(4, build(4, "Игорь", "Игорев", "Игоревич", "аспирант", 5, "zyx", "654"));
    }

    public static List<Username> readAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT \"id\", \"firstname\" , \"surname\", \"lostname\", \"status\", \"group\", \"login\", \"password\" FROM \"username\"";
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
            try {
                Objects.requireNonNull(resultSet).close();
            } catch (Exception ignored) {
            }
            try {
                Objects.requireNonNull(statement).close();
            } catch (Exception ignored) {
            }
            try {
                Objects.requireNonNull(connection).close();
            } catch (Exception ignored) {
            }
        }
    }

    public static Username read(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT \"id\", \"firstname\" , \"surname\", \"lostname\", \"status\", \"group\", \"login\", \"password\" FROM \"username\" WHERE \"id\" = ?";
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

    public static void create(Username username) {
        int newId = 1;
        if(usernames.keySet().isEmpty()) {
            newId += Collections.max(usernames.keySet());
        }
        username.setId(newId);
        usernames.put(newId, username);
    }

    public static void update(Username username) {
        if(usernames.containsKey(username.getId())) {
            usernames.put(username.getId(), username);
        }
    }

    public static void delete(Integer id) {
        usernames.remove(id);
    }

    private static Username build(Integer id, String firstname,
                                  String surname, String lostname,
                                  String status, Integer group,
                                  String login, String password) {
        Username username = new Username();
        username.setId(id);
        username.setFirstname(firstname);
        username.setSurname(surname);
        username.setLostname(lostname);
        username.setStatus(status);
        username.setGroup(group);
        username.setLogin(login);
        username.setPassword(password);
        return username;
    }
}
