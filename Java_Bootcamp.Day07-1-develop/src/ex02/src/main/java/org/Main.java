package org;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.models.User;
import org.processor.OrmManager;


public class Main {
    public static void main(String[] args) {
        HikariDataSource dataSource;
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost/elodiawy");
        dataSource = new HikariDataSource(config);
        OrmManager manager = new OrmManager(dataSource);
        manager.create();
        User user = new User(1L, "Bolot", "Arnaliev", 45);
        manager.save(user);
        User user1 = new User(1L, "Kubat", "Arnaliev", 45);
        manager.update(user1);
        manager.findById(1L, user1.getClass());
    }
}