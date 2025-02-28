import java.io.FileWriter;
import java.util.Scanner;
import java.sql.*;
import java.io.IOException;
import java.io.BufferedWriter;


public class Main1 {

    static String tablename = "operations";
    static String mysqlURL = "jdbc:mysql://localhost/db1";

    public static void main(String[] args) throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Вывести все таблицы из MySQL.\n" +
                    "2. Создать таблицу в MySQL.\n" +
                    "3. Сложение чисел, результат сохранить в MySQL с последующим выводом в консоль.\n" +
                    "4. Вычитание чисел, результат сохранить в MySQL с последующим выводом в консоль.\n" +
                    "5. Умножение чисел, результат сохранить в MySQL с последующим выводом в консоль.\n" +
                    "6. Деление чисел, результат сохранить в MySQL с последующим выводом в консоль.\n" +
                    "7. Деление чисел по модулю (остаток), результат сохранить в MySQL с последующим выводом в консоль.\n" +
                    "8. Возведение числа в модуль, результат сохранить в MySQL с последующим выводом в консоль.\n" +
                    "9. Возведение числа в степень, результат сохранить в MySQL с последующим выводом в консоль.\n" +
                    "10. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран.\n" +
                    "0. Завершить программу");

            int n = sc.nextInt();

            switch (n) {
                case 1 -> showTables();
                case 2 -> createTable();
                case 3 -> {
                    System.out.println("Введите первое число: ");
                    if (sc.hasNextInt()) {
                       int num1 = sc.nextInt();
                       System.out.println("Введите второе число: ");
                       int num2 = sc.nextInt();
                       System.out.println(operation(num1, num2, "addition"));
                    }
                    else if (sc.hasNextDouble()) {
                        Double num1 = sc.nextDouble();
                        System.out.println("Введите второе число: ");
                        Double num2 = sc.nextDouble();
                        System.out.println(operation(num1, num2, "addition"));
                    }
                    else if (sc.hasNextByte()) {
                        byte num1 = sc.nextByte();
                        System.out.println("Введите второе число: ");
                        byte num2 = sc.nextByte();
                        System.out.println(operation(num1, num2, "addition"));
                    }
                }
                case 4 -> {
                    System.out.println("Введите первое число: ");
                    if (sc.hasNextInt()) {
                        int num1 = sc.nextInt();
                        System.out.println("Введите второе число: ");
                        int num2 = sc.nextInt();
                        System.out.println(operation(num1, num2, "subtraction"));
                    }
                    else if (sc.hasNextDouble()) {
                        Double num1 = sc.nextDouble();
                        System.out.println("Введите второе число: ");
                        Double num2 = sc.nextDouble();
                        System.out.println(operation(num1, num2, "subtraction"));
                    }
                    else if (sc.hasNextByte()) {
                        byte num1 = sc.nextByte();
                        System.out.println("Введите второе число: ");
                        byte num2 = sc.nextByte();
                        System.out.println(operation(num1, num2, "subtraction"));
                    }
                }
                case 5 -> {
                    System.out.println("Введите первое число: ");
                    if (sc.hasNextInt()) {
                        int num1 = sc.nextInt();
                        System.out.println("Введите второе число: ");
                        int num2 = sc.nextInt();
                        System.out.println(operation(num1, num2, "multiplication"));
                    }
                    else if (sc.hasNextDouble()) {
                        Double num1 = sc.nextDouble();
                        System.out.println("Введите второе число: ");
                        Double num2 = sc.nextDouble();
                        System.out.println(operation(num1, num2, "multiplication"));
                    }
                    else if (sc.hasNextByte()) {
                        byte num1 = sc.nextByte();
                        System.out.println("Введите второе число: ");
                        byte num2 = sc.nextByte();
                        System.out.println(operation(num1, num2, "multiplication"));
                    }
                }
                case 6 -> {
                    System.out.println("Введите первое число: ");
                    if (sc.hasNextInt()) {
                        int num1 = sc.nextInt();
                        System.out.println("Введите второе число: ");
                        int num2 = sc.nextInt();
                        System.out.println(operation(num1, num2, "division"));
                    }
                    else if (sc.hasNextDouble()) {
                        Double num1 = sc.nextDouble();
                        System.out.println("Введите второе число: ");
                        Double num2 = sc.nextDouble();
                        System.out.println(operation(num1, num2, "division"));
                    }
                    else if (sc.hasNextByte()) {
                        byte num1 = sc.nextByte();
                        System.out.println("Введите второе число: ");
                        byte num2 = sc.nextByte();
                        System.out.println(operation(num1, num2, "division"));
                    }
                }
                case 7 -> {
                    System.out.println("Введите первое число: ");
                    if (sc.hasNextInt()) {
                        int num1 = sc.nextInt();
                        System.out.println("Введите второе число: ");
                        int num2 = sc.nextInt();
                        System.out.println(operation(num1, num2, "moduleDivision"));
                    }
                    else if (sc.hasNextDouble()) {
                        Double num1 = sc.nextDouble();
                        System.out.println("Введите второе число: ");
                        Double num2 = sc.nextDouble();
                        System.out.println(operation(num1, num2, "moduleDivision"));
                    }
                    else if (sc.hasNextByte()) {
                        byte num1 = sc.nextByte();
                        System.out.println("Введите второе число: ");
                        byte num2 = sc.nextByte();
                        System.out.println(operation(num1, num2, "moduleDivision"));
                    }
                }
                case 8 -> {
                    System.out.println("Введите первое число: ");
                    if (sc.hasNextInt()) {
                        int num1 = sc.nextInt();
                        System.out.println("Введите второе число: ");
                        int num2 = sc.nextInt();
                        System.out.println(operation(num1, num2, "modulePow"));
                    }
                    else if (sc.hasNextDouble()) {
                        Double num1 = sc.nextDouble();
                        System.out.println("Введите второе число: ");
                        Double num2 = sc.nextDouble();
                        System.out.println(operation(num1, num2, "modulePow"));
                    }
                    else if (sc.hasNextByte()) {
                        byte num1 = sc.nextByte();
                        System.out.println("Введите второе число: ");
                        byte num2 = sc.nextByte();
                        System.out.println(operation(num1, num2, "modulePow"));
                    }
                }
                case 9 -> {
                    System.out.println("Введите первое число: ");
                    if (sc.hasNextInt()) {
                        int num1 = sc.nextInt();
                        System.out.println("Введите второе число: ");
                        int num2 = sc.nextInt();
                        System.out.println(operation(num1, num2, "pow"));
                    }
                    else if (sc.hasNextDouble()) {
                        Double num1 = sc.nextDouble();
                        System.out.println("Введите второе число: ");
                        Double num2 = sc.nextDouble();
                        System.out.println(operation(num1, num2, "pow"));
                    }
                    else if (sc.hasNextByte()) {
                        byte num1 = sc.nextByte();
                        System.out.println("Введите второе число: ");
                        byte num2 = sc.nextByte();
                        System.out.println(operation(num1, num2, "pow"));
                    }
                }
                case 10 -> saveToExcel();

                case 0 -> running = false;
                default -> System.out.println("Введено неверное число");
            }
        }
    }

    private static void showTables() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        System.out.println("Успешное подключение к базе данных");
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery("show tables");
        System.out.println("Таблицы из текущей базы данных: ");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println();
        }
    }

    private static void createTable() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        System.out.println("Успешное подключение к базе данных");
        Statement statement = connection.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS " + tablename + "(var1 varchar(255), operation varchar(255), var2 varchar(255), result varchar(255))";
        statement.executeUpdate(query);
        ResultSet resultSet = statement.executeQuery("show tables");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println();
        }
    }

    private static void saveOperation(String var1, String var2, String operation, String result) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        System.out.println("Успешное подключение");
        Statement statement = connection.createStatement();
        String query = "INSERT INTO " +  tablename +  " (var1, operation, var2, result) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, var1);
            pstmt.setString(3, operation);
            pstmt.setString(2, var2);
            pstmt.setString(4, result);
            pstmt.executeUpdate();
            System.out.println("Операция сохранена в базе данных.");
        }
    }

    private static int operation(int num1, int num2, String operation) throws SQLException{
        Scanner sc = new Scanner(System.in);
        switch (operation) {
            case "addition" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 + num2));
                return (int) num1 + num2;
            }
            case "subtraction" -> {
                saveOperation(String.valueOf(num1), operation,String.valueOf(num2), String.valueOf(num1 - num2));
                return (int) num1 - num2;
            }
            case "multiplication" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 * num2));
                return (int) num1 * num2;
            }
            case "division" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 / num2));
                return (int) num1 / num2;
            }
            case "moduleDivision" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 % num2));
                return (int) num1 % num2;
            }
            case "modulePow" -> {
                System.out.println("Введите число для деления по модулю: ");
                int num3 = sc.nextInt();
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(Math.pow(num1, num2) % num3));
                return (int) Math.pow(num1, num2) % num3;
            }
            case "pow" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(Math.pow(num1, num2)));
                return (int) Math.pow(num1, num2);
            }
        }
        return 0;
    }

    private static Double operation(Double num1, Double num2, String operation) throws SQLException {
        Scanner sc = new Scanner(System.in);
        switch (operation) {
            case "addition" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 + num2));
                return (Double) num1 + num2;
            }
            case "subtraction" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 - num2));
                return (Double) num1 - num2;
            }
            case "multiplication" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 * num2));
                return (Double) num1 * num2;
            }
            case "division" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 / num2));
                return (Double) num1 / num2;
            }
            case "moduleDivision" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 % num2));
                return (Double) num1 % num2;
            }
            case "modulePow" -> {
                System.out.println("Введите число для деления по модулю: ");
                Double num3 = sc.nextDouble();
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(Math.pow(num1, num2) % num3));
                return (Double) Math.pow(num1, num2) % num3;
            }
            case "pow" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(Math.pow(num1, num2)));
                return (Double) Math.pow(num1, num2);
            }
        }
        return null;
    }

    private static byte operation(byte num1, byte num2, String operation) throws SQLException {
        Scanner sc = new Scanner(System.in);
        switch (operation) {
            case "addition" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 + num2));
                return (byte) (num1 + num2);
            }
            case "subtraction" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 - num2));
                return (byte) (num1 - num2);
            }
            case "multiplication" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 * num2));
                return (byte) (num1 * num2);
            }
            case "division" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 / num2));
                return (byte) (num1 / num2);
            }
            case "moduleDivision" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(num1 % num2));
                return (byte) (num1 % num2);
            }
            case "modulePow" -> {
                System.out.println("Введите число для деления по модулю: ");
                byte num3 = sc.nextByte();
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(Math.pow(num1, num2) % num3));
                return (byte) (Math.pow(num1, num2) % num3);
            }
            case "pow" -> {
                saveOperation(String.valueOf(num1), operation, String.valueOf(num2), String.valueOf(Math.pow(num1, num2)));
                return (byte) Math.pow(num1, num2);
            }
        }
        return 0;
    }
    private static void saveToExcel() throws SQLException, IOException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection connection = DriverManager.getConnection(mysqlURL, "root", "D1i2m3a40807!");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tablename + ";");
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_operations.csv"));

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
