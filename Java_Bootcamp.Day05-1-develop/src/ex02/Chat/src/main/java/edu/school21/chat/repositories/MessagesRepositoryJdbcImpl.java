package edu.school21.chat.repositories;

import edu.school21.chat.exeptions.NotSavedSubEntityException;
import edu.school21.chat.models.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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
        User user = new User(1L, "user", "password", new ArrayList<>(), new ArrayList<>());
        Chatroom chatroom = new Chatroom(1L, "ChatName", null, null);
        Message message = new Message(set.getLong(1), user, chatroom, set.getString("text"), set.getTimestamp("timestamp").toLocalDateTime());
        optionalMessage = Optional.of(message);
        return optionalMessage;
    }

    @Override
    public void save(Message message) throws NotSavedSubEntityException {
        String query = "insert into chat.messages (author, room, text, timestamp) values (?, ?, ?, ?) returning *";
        try (Connection connection = dataSource.getConnection() ;
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, message.getMessageAuthor().getUserId());
            statement.setLong(2, message.getRoom().getChatRoomId());
            statement.setString(3, message.getMessageText());
            statement.setTimestamp(4, Timestamp.valueOf(message.getDataTime()));
            statement.execute();
            ResultSet set = statement.getGeneratedKeys();
            set.next();
            message.setMessageId(set.getLong("id"));
        }
        catch (SQLException E) {
            throw new NotSavedSubEntityException();
        }

    }
}
