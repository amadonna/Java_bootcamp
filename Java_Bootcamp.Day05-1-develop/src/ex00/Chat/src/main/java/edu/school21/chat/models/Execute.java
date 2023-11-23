package edu.school21.chat.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute {
    private final Connection connection;
    public Execute(Connection connection) {
        this.connection = connection;
    }
    public void run (String[] queries) {
        try (Statement statement = connection.createStatement()) {
            for (String q : queries) {
                System.out.println(q);
                statement.execute(q);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
