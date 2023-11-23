package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long chatRoomId;
    private String chatRoomName;
    private User owner;
    private List<Message> messages;

    public Chatroom(Long chatRoomId, String chatRoomName, User owner, List<Message> messages) {
        this.chatRoomId = chatRoomId;
        this.chatRoomName = chatRoomName;
        this.owner = owner;
        this.messages = messages;
    }

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


}
