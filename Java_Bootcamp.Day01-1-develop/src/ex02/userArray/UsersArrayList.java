package src.ex02.userArray;
import src.ex02.user.User;

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
        User [] temp = new User[newSize];
        for (int i = 0; i < users.length; i++) {
            temp[i] = users[i];
        }
        return temp;
    }

    private User[] increaseSize() {
        int currentSize = userArray.length;
        int newSize;
        if (currentSize > 0 || userArray != emptyArrayUsers) {
            newSize = currentSize * DEFAULT_INCREASE;
            userArray = copyArray(userArray, newSize);
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
        boolean stop = true;
        int i = 0;
        while (i < size && stop) {
            if (userArray[i].getIdentifier() == id) {
                stop = false;
            }
            i++;
        }
        if (stop) {
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
