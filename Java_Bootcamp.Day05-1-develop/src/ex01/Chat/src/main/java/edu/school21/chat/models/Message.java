package edu.school21.chat.models;

import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private Long messageId;
    private User messageAuthor;
    private Chatroom room;
    private String messageText;
    private LocalDateTime dataTime;
    public Message(Long messageId , User user, Chatroom chatroom, String messageText, LocalDateTime localDateTime) {
        this.messageId = messageId;
        this.messageAuthor = user;
        this.room = chatroom;
        this.messageText = messageText;
        this.dataTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message message)) return false;
        return getMessageId().equals(message.getMessageId()) && getMessageAuthor().equals(message.getMessageAuthor()) && getRoom().equals(message.getRoom()) && getMessageText().equals(message.getMessageText()) && getDataTime().equals(message.getDataTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessageId(), getMessageAuthor(), getRoom(), getMessageText(), getDataTime());
    }

    @Override
    public String toString() {
        return "Message : {" + '\n' +
                "messageId=" + messageId + ",\n\t" +
                "author=" + messageAuthor.toString() + ",\n\t" +
                "room=" + room.toString() + ",\n\t" +
                "messageText=" + '"' + "messageText" + '"' + ",\n\t" +
                "dataTime=" + dataTime.format(DateTimeFormatter.ofPattern("MM/MM/yy HH:mm")) + ",\n" +
                '}';
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public User getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(User messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }
}
