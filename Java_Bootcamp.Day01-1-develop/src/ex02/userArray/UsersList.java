package src.ex02.userArray;
import src.ex02.user.User;
public interface UsersList {
    boolean addUser(User user);
    User getById(int id);
    User getByIndex(int idx);
    int getCountOfUsers();
}
