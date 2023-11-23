package edu.school21.chat.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost/elodiawy";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(connectionUrl);
            Execute execute = new Execute(connection);
            String[] queriesSchema = ReadQueries.getQueries("/Users/elodiawy/Java/Java_Bootcamp.Day05-1/src/ex00/src/main/resources/schema.sql");
            String[] queriesData = ReadQueries.getQueries("/Users/elodiawy/Java/Java_Bootcamp.Day05-1/src/ex00/src/main/resources/data.sql");
            execute.run(queriesSchema);
            execute.run(queriesData);
            execute.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
