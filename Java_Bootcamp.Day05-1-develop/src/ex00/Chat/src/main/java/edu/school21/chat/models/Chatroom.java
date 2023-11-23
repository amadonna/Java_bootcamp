package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long chatRoomId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return Objects.equals(chatRoomId, chatroom.chatRoomId) && Objects.equals(chatRoomName, chatroom.chatRoomName) && Objects.equals(owner, chatroom.owner) && Objects.equals(messages, chatroom.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatRoomId, chatRoomName, owner, messages);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "chatRoomId=" + chatRoomId +
                ", chatRoomName='" + chatRoomName + '\'' +
                ", owner=" + owner +
                ", messages=" + messages +
                '}';
    }

    private String chatRoomName;
    private User owner;

    public Long getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    private List<Message> messages;

}
