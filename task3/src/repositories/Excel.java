package repositories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Excel {

    public static void writeData(String filename, ResultSet data) throws IOException, SQLException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        ResultSetMetaData metaData = data.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i < columnCount; i++) {
            writer.write(metaData.getColumnName(i));
            System.out.print(metaData.getColumnName(i) + "\t");

            writer.write(",");
            System.out.print("\t");
        }

        writer.newLine();

        while (data.next()) {
            for (int i = 1; i < columnCount; i++) {
                String value = data.getString(i);
                writer.write(data.getString(i));

                System.out.print(value + "\t");
                writer.write(",");
                System.out.print("\t");
            }

            writer.newLine();
            System.out.println();
        }
    }
}
