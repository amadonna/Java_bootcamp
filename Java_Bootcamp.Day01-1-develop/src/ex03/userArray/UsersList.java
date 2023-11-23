package src.ex03.userArray;
import src.ex03.user.User;
public interface UsersList {
    boolean addUser(User user);
    User getById(int id);
    User getByIndex(int idx);
    int getCountOfUsers();
}
