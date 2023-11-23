package src.ex04.userArray;

import src.ex04.user.User;

public interface UsersList {
    boolean addUser(User user);
    User getById(int id);
    User getByIndex(int idx);
    int getCountOfUsers();
}
