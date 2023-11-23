package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private Long userId;
    private String login;
    private String password;
    private List<Chatroom> chatRooms;
    private List<Chatroom> socialChatRooms;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getUserId().equals(user.getUserId()) && getLogin().equals(user.getLogin()) && getPassword().equals(user.getPassword()) && Objects.equals(getChatRooms(), user.getChatRooms()) && Objects.equals(getSocialChatRooms(), user.getSocialChatRooms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getLogin(), getPassword(), getChatRooms(), getSocialChatRooms());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", chatRooms=" + chatRooms +
                ", socialChatRooms=" + socialChatRooms +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setChatRooms(List<Chatroom> chatRooms) {
        this.chatRooms = chatRooms;
    }

    public List<Chatroom> getChatRooms() {
        return chatRooms;
    }

    public void setSocialChatRooms(List<Chatroom> socialChatRooms) {
        this.socialChatRooms = socialChatRooms;
    }

    public List<Chatroom> getSocialChatRooms() {
        return socialChatRooms;
    }

}
