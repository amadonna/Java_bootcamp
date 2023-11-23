package edu.school21.chat.app;


import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Optional;

public class PrintPropeties {
    public static void show(Long id, DataSource dataSource) {
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
        try {
            Optional<Message> message = messagesRepository.findById(id);
            if (message.isPresent()) {
                Message message1 = message.get();
                System.out.println(message1);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
