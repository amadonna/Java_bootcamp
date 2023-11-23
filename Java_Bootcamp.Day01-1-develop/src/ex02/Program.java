package src.ex02;
import src.ex02.user.User;
import src.ex02.userArray.UsersArrayList;
import src.ex02.userArray.UsersList;

public class Program {
    public static void main (String[] args) {
        int num = 5;
        User[] users = new User[num];
        for (int i = 0; i < num; i++) {
            users[i] = new User("Bolot" + "_" + i, 15.5 + i * 1.5);
        }
        UsersList arr = new UsersArrayList();
        for (int i = 0; i < num; i++) {
            arr.addUser(users[i]);
        }
        for (int i = 0; i < num; i++) {
            System.out.println(arr.getByIndex(i).getIdentifier() + "\t" + arr.getByIndex(i).getName() + "\t" + arr.getByIndex(i).getBalance());
        }
        System.out.println();
        for (int i = 0; i < num; i++) {
            System.out.println(arr.getById(i).getIdentifier() + "\t" + arr.getById(i).getName() + "\t" + arr.getById(i).getBalance());
        }
        System.out.println("count of users = " + arr.getCountOfUsers());
        System.out.println("incorrect : " + arr.getByIndex(40));
    }
}
