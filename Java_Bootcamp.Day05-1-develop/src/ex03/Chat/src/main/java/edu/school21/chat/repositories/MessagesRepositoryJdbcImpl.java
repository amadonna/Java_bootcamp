package edu.school21.chat.repositories;

import edu.school21.chat.exeptions.NotSavedSubEntityException;
import edu.school21.chat.models.*;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource dataSource;
    public MessagesRepositoryJdbcImpl (DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public Optional<Message> findById(Long id) {
        String query = "select * from chat.messages where id = " + id;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);
            set.next();
            User user = new User(1L, "user", "password", new ArrayList<>(), new ArrayList<>());
            Chatroom chatroom = new Chatroom(1L, "ChatName", null, null);
            Message message = new Message(set.getLong(1), user, chatroom, set.getString("text"), set.getTimestamp("timestamp").toLocalDateTime());
            return Optional.of(message);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
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

    @Override
    public boolean update(Message message) {
        String query = "UPDATE chat.Messages SET " +
                "author = ?, room = ?, text = ?, timestamp = ? " +
                "WHERE id = ?;";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setLong(1, message.getMessageAuthor().getUserId());
            statement.setLong(2, message.getRoom().getChatRoomId());
            statement.setString(3, message.getMessageText());
            try {
                statement.setTimestamp(4, Timestamp.valueOf(message.getDataTime()));
            }
            catch (NullPointerException e) {
                statement.setString(4, LocalDateTime.now().toString());
            }
            statement.setLong(5, message.getMessageId());
            statement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
