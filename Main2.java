import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.sql.*;

public class Main2 {

    static String mysqlURL = "jdbc:mysql://localhost/db1";
    static String tablename = "twoLines";
    static String line1;
    static String line2;

    public static void main(String[] args) throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Вывести все таблицы из MySQL.\n" +
                    "2. Создать таблицу в MySQL.\n" +
                    "3. Ввести две строки с клавиатуры, результат сохранить в MySQL с последующим выводом в\n" +
                    "консоль.\n" +
                    "4. Подсчитать размер ранее введенных строк, результат сохранить в MySQL с последующим\n" +
                    "выводом в консоль.\n" +
                    "5. Объединить две строки в единое целое, результат сохранить в MySQL с последующим выводом\n" +
                    "в консоль.\n" +
                    "6. Сравнить две ранее введенные строки, результат сохранить в MySQL с последующим выводом\n" +
                    "в консоль.\n" +
                    "7. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран.");

            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1 -> showTables();
                case 2 -> createTable();
                case 3 -> inputLines();
                case 4 -> countLinesSize();
                case 5 -> addLines();
                case 6 -> compareLines();
                case 7 -> saveToExcel();
                case 0 -> running = false;
                default -> System.out.println("Введено неверное число");
            }
        }
    }

    private static void showTables() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SHOW TABLES");
        System.out.println("Таблицы из текущей базы данных: ");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println();
        }
    }

    private static void createTable() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        Statement statement = connection.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS `" + tablename + "` (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "line1 VARCHAR(255), " +
                "line2 VARCHAR(255), " +
                "operation VARCHAR(255), " +
                "result VARCHAR(255));";
        statement.executeUpdate(query);
        ResultSet resultSet = statement.executeQuery("show tables");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println();
        }
    }

    private static void inputLines() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первую строку: ");
        line1 = sc.nextLine();
        line2 = sc.nextLine();

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        Statement statement = connection.createStatement();
        String query = "INSERT INTO `" + tablename + "` (line1, line2, operation, result) VALUES(?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, line1);
            preparedStatement.setString(2, line2);
            preparedStatement.setString(3, "input");
            preparedStatement.setString(4, "-");
            preparedStatement.executeUpdate();
            System.out.println("Строки сохранены");
        }
    }

    private static void countLinesSize() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        Statement statement = connection.createStatement();
        String query = "INSERT INTO `" + tablename + "`  (line1, line2, operation, result) VALUES(?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, line1);
            preparedStatement.setString(2, line2);
            preparedStatement.setString(3, "size line1/line2");
            preparedStatement.setString(4, String.valueOf(line1.length()) + "/" + String.valueOf(line2.length()));
            preparedStatement.executeUpdate();
            System.out.println("размер 1 строки: " + String.valueOf(line1.length()) + ", размер второй строки: " +String.valueOf(line2.length()));
        }
    }

    private static void addLines() throws SQLException {
        String concat = line1 + line2;
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        Statement statement = connection.createStatement();
        String query = "INSERT INTO `" + tablename + "` (line1, line2, operation, result) VALUES(?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, line1);
            preparedStatement.setString(2, line2);
            preparedStatement.setString(3, "concat_lines");
            preparedStatement.setString(4, concat);
            preparedStatement.executeUpdate();
            System.out.println("Строка 1 + строка 2 = " + concat);
        }
    }

    private static void compareLines() throws SQLException {
        boolean isEqual = line1.equals(line2);
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        Statement statement = connection.createStatement();
        String query = "INSERT INTO `" + tablename + "` (line1, line2, operation, result) VALUES(?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, line1);
            preparedStatement.setString(2, line2);
            preparedStatement.setString(3, "is_equal");
            preparedStatement.setString(4, String.valueOf(isEqual));
            preparedStatement.executeUpdate();
            System.out.println("Строка 1 соответствует строке 2: " + String.valueOf(isEqual));
        }
    }



    private static void saveToExcel() throws SQLException, IOException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `" + tablename + "`;");
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_lines.csv"));

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i < columnCount; i++) {
            writer.write(metaData.getColumnName(i));
            System.out.print(metaData.getColumnName(i) + "\t");
            if (i < columnCount) {
                writer.write(",");
                System.out.print("\t");
            }
        }
        writer.newLine();

        while (resultSet.next()) {
            for (int i = 1; i < columnCount; i++) {
                String value = resultSet.getString(i);
                writer.write(resultSet.getString(i));
                System.out.print(value + "\t");
                if (i < columnCount) {
                    writer.write(",");
                    System.out.print("\t");
                }
            }
            writer.newLine();
            System.out.println();
        }

        System.out.println("Экспорт данных завершен");
    }
}
