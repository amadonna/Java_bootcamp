package src.ex05.menu;

import src.ex05.user.User;

import java.util.Scanner;

public class AddUser {
    private static String name ;
    private static double amount;
    public static User addUser(Scanner scanner) {
        System.out.println("Enter a user name and a balance");
        boolean stop = false;
        while (!stop) {
            if (scanner.hasNext()) {
                name = scanner.next();
                if (scanner.hasNextDouble()) {
                    amount = scanner.nextDouble();
                    stop = true;
                }
                else {
                    System.out.println("Incorrect name or amount");
                }
            }
            else {
                System.out.println("Incorrect name or amount");
            }
        }
        return new User(name, amount);
    }
}
