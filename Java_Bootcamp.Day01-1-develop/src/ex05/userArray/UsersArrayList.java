package src.ex05.userArray;
import src.ex05.user.User;

public class UsersArrayList implements UsersList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_INCREASE = 2;
    private static final User[] emptyArrayUsers = {};
    private User[] userArray;

    private int size;

    public UsersArrayList() {
        this.userArray = emptyArrayUsers;
    }

    public UsersArrayList(int initCapacity) {
        if (initCapacity > 0) {
            this.userArray = new User[initCapacity];
        }
        else if (initCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity");
        }
        else {
            this.userArray = emptyArrayUsers;
        }
    }

    private User[] copyArray(User[] users, int newSize) {
        User[] temp = new User[newSize];
        for (int i = 0; i < users.length; i++) {
            temp[i] = users[i];
        }
        return temp;
    }

    private User[] increaseSize() {
        if (userArray.length > 0 || userArray != emptyArrayUsers) {
            userArray = copyArray(userArray, userArray.length * DEFAULT_INCREASE);
        }
        else {
            userArray = new User[DEFAULT_CAPACITY];
        }
        return userArray;
    }

    @Override
    public boolean addUser(User user) {
        if (size == userArray.length) {
            userArray = increaseSize();
        }
        userArray[size] = user;
        size++;
        return  (userArray[size - 1] == user);
    }
    @Override
    public User getById(int id) {
        int i = 0;
        while (i < size && userArray[i].getIdentifier() != id) {
            i++;
        }
        if (userArray[i] == null || userArray[i].getIdentifier() != id) {
            throw new UserNotFoundException("There is not user with Id = " + id);
        }
        return userArray[i];
    }

    @Override
    public User getByIndex(int idx) {
        if (idx > size - 1 || idx < 0 || userArray[idx] == null) {
            throw new UserNotFoundException("IllegalIndex");
        }
        return userArray[idx];
    }

    @Override
    public int getCountOfUsers() {
        return size;
    }
}
