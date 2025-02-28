import repositories.Excel;
import repositories.Mysql;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    protected static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, IOException {
        boolean running = Mysql.init();

        while (running) {
            System.out.println("1. Вывести все таблицы из MySQL.");
            System.out.println("2. Создать таблицу в MySQL.");
            System.out.println("3. Проверить, что числа целые и чётные.");
            System.out.println("4. Сохранить результаты в Excel.");
            System.out.println("0. Остановить программу.");

            int input = scanner.nextInt();

            switch (input) {
                case 1 -> showTables();
                case 2 -> createTable();
                case 3 -> checkNumbers();
                case 4 -> saveToExcel();
                case 0 -> running = false;
                default -> System.out.println("Введено неверное значение.");
            }
        }
    }

    private static void showTables() throws SQLException{
        ResultSet tablesRaw = Mysql.showTables();

        System.out.println("Таблицы из Mysql базы данных: ");

        while (tablesRaw.next()) {
            System.out.println(tablesRaw.getString(1));
        }

        tablesRaw.close();
    }

    private static void createTable() throws SQLException {
        Mysql.migrate();
        System.out.println("Успешное создание таблицы.");
    }

    private static void checkNumbers() throws SQLException {
        System.out.println("Введите числа, пока не будет введено нечисловое значение: ");

        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();

                boolean isEven = number % 2 == 0;

                Mysql.insertOperation(String.valueOf(number), isEven);

                System.out.println("Введенное число " + number + " целое и " + (isEven ? "чётное." : "нечётное."));

                continue;
            }

            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();

                Mysql.insertOperation(String.valueOf(number), false);

                System.out.println("Введенное число " + number +" не целое.");

                continue;
            }

            scanner.next();
            System.out.println("Введенное значение не является числом, завершаем ввод.");

            break;
        }
    }

    private static void saveToExcel() throws SQLException, IOException {
        ResultSet data = Mysql.selectAll();

        Excel.writeData("output.csv", data);

        System.out.println("Успешная запись в Excel.");

        data.close();
    }

}