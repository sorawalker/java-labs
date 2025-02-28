package repositories;

import java.sql.*;

public class Mysql {
    static String table = "reference";
    static String mysqlURL = "jdbc:mysql://localhost:3306/task3";
    static Connection connection;

    static {
        try {
            connection = createConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean init() {
        return true;
    }

    private static Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "dev");
        System.out.println("Успешное подключение к базе данных");

        return connection;
    }

    public static void migrate() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS " + table + "(id int PRIMARY KEY AUTO_INCREMENT, input varchar(255), isEven Boolean)";

        statement.executeUpdate(query);

        statement.close();
    }

    public static ResultSet showTables() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SHOW TABLES";

        return statement.executeQuery(query);
    }

    public static void insertOperation(String input, Boolean result) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "INSERT INTO " +  table +  " (input, isEven) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, input);
        preparedStatement.setBoolean(2, result);
        preparedStatement.executeUpdate();

        statement.close();
    }

    public static ResultSet selectAll() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM " + table + ";";

        return statement.executeQuery(query);
    }
}
