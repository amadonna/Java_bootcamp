package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;

public class Program {
    public static void main(String[] args) {
        HikariDataSource dataSource;
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost/elodiawy");
        dataSource = new HikariDataSource(config);
        long id = GetId.id();
        boolean check = false;
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
        Optional<Message> messageOptional;
        messageOptional = messagesRepository.findById(id);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setMessageText("Bye");
            message.setDataTime(null);
            check = messagesRepository.update(message);
        }
        if (check) {
            System.out.println("updated");
        }
        else {
            System.out.println("not updated");
        }
    }
}
