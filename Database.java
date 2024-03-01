package edu.wsu.myapplication;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;

public class Database {
    private static Database instance;
    private static final String URL = "jdbc:sqlserver://database-1.cfase6a4uwz6.us-east-2.rds.amazonaws.com:1433/FinanceAnalyzer?user=admin&password=FinanceAnalyzer";


    private Connection connection;

    private Database() {
        try {
            // Attempt to establish a database connection upon instantiation
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }

    public boolean authenticateUser(String username, String password) {
        // Assume the users table has 'username' and 'password' columns
        String query = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password); // Note: In real applications, use hashed passwords
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void insertIntoTable(String tableName, String name, String place) throws SQLException {
        String query = "INSERT INTO " + tableName + " (name, place) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, place);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String retrieveFromTable(String tableName) throws SQLException {
        StringBuilder records = new StringBuilder();
        String query = "SELECT * FROM " + tableName;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                records.append("Name: ").append(resultSet.getString("name")).append(", Place: ").append(resultSet.getString("place")).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return records.toString();
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
