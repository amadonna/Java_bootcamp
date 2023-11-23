package src.ex05.userArray;

import src.ex05.user.User;

public interface UsersList {
    boolean addUser(User user);
    User getById(int id);
    User getByIndex(int idx);
    int getCountOfUsers();
}
