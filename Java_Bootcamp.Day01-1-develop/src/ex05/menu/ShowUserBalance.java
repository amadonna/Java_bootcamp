package src.ex05.menu;

import src.ex05.service.TransactionsService;
import java.util.InputMismatchException;

import java.util.Scanner;

public class ShowUserBalance {
    public static void showBalance(TransactionsService transactionsService, Scanner scanner) {
        System.out.println("Enter a user ID");
        scanner = new Scanner(System.in);
        int id = 0;
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input. Expected a number");
            scanner.nextLine();
        }
        try {
            System.out.println(transactionsService.getUser(id).getName() + " - " + transactionsService.getUserBalance(id));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
