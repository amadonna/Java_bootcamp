package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource dataSource;
    public MessagesRepositoryJdbcImpl (DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage;
        String query = "select * from chat.messages where id = " + id;
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery(query);
        set.next();
        User user = new User(1L, "user", "password", null, null);
        Chatroom chatroom = new Chatroom(1L, "ChatName", null, null);
        Message message = new Message(set.getLong(1), user, chatroom, set.getString("text"), set.getTimestamp("timestamp").toLocalDateTime());
        optionalMessage = Optional.of(message);
        connection.close();
        return optionalMessage;
    }
}
