package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        HikariDataSource dataSource;
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost/elodiawy");
        dataSource = new HikariDataSource(config);
        System.out.println("Enter a message ID");
        Scanner scanner = new Scanner(System.in);
        long id = 0L;
        if (scanner.hasNextLong()) {
            id = scanner.nextLong();
        }
        scanner.close();
        PrintPropeties.show(id, dataSource);
    }
}
