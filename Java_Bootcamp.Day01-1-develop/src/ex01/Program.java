package src.ex01;
import src.ex01.user.User;
public class Program {

    public static void main(String[] args) {
        User users = new User("Bolot", 12.3);
        System.out.println(users.getName() + "\tid:" + users.getIdentifier() + "\tbalance:" + users.getBalance());
        users.setName("Bolot2");
        users.setBalance(20.3);
        System.out.println(users.getName() + "\tid:" + users.getIdentifier() + "\tbalance:" + users.getBalance());
        User users2 = new User("Bolot3", 42.3);
        System.out.println(users2.getName() + "\tid:" + users2.getIdentifier() + "\tbalance:" + users2.getBalance());
        User users3 = new User("Bolot4", 100.3);
        System.out.println(users3.getName() + "\tid:" + users3.getIdentifier() + "\tbalance:" + users3.getBalance());
    }
}
