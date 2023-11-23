package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        HikariDataSource dataSource;
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost/elodiawy");
        dataSource = new HikariDataSource(config);
        User author;
        User creator = new User(5L, "user", "user", new ArrayList<>(), new ArrayList<>());
        author = creator;
        Chatroom chatroom = new Chatroom(5L, "room", creator,new ArrayList<>());
        Message message = new Message(null, author, chatroom, "Hello!" , LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
        messagesRepository.save(message);
        System.out.println("id == " + message.getMessageId());

    }
}
