package src.ex05.menu;

import src.ex05.service.TransactionsService;
import java.util.InputMismatchException;
import java.util.UUID;
import src.ex05.user.User;
import src.ex05.trasaction.Transaction;
import java.util.Scanner;


public class Menu {
    private static TransactionsService transactionsService;
    private static  Scanner scanner;
    private static boolean dev = false;
    public static void menu(boolean remote) {
        transactionsService = new TransactionsService();
        scanner = new Scanner(System.in);
        dev = remote;
        while (true) {
            PrintMenu.print();
            int number = 0;
            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input. Expected a number");
                scanner.nextLine();
            }
            switch (number) {
                case 1:
                    add();
                    break;
                case 2:
                    ShowUserBalance.showBalance(transactionsService, scanner);
                    break;
                case 3:
                    performTransfer();
                    break;
                case 4:
                    printTransactions();
                    break;
                case 5:
                    remove();
                    break;
                case 6:
                    checkValidity();
                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
            System.out.println("---------------------------------------------------------");
        }
    }
    private static void checkValidity() {
        if (!dev) return;
        System.out.println("Check results:");
        Transaction[] unpairedTransactions = transactionsService.unpairedTransaction();
        System.out.println("lenght = : " + unpairedTransactions.length);
        if (unpairedTransactions.length == 0) {
            System.out.println("Unacknowledged transfers not found");
            return;
        }
        for (Transaction t : unpairedTransactions) {
            System.out.println(transactionInfo(t));
        }
    }
    private static String transactionInfo(Transaction transaction) {
        boolean isSender = true;
        User user = transaction.getSender();
        try {
            user.getTransaction().findTransaction(transaction.getIdentifier());
        } catch (RuntimeException e) {
            isSender = false;
            user = transaction.getRecipient();
        }
        String info = user.getName() + "(id = " + user.getIdentifier() + ") has an unacknowledged transfer id = " + transaction.getIdentifier();
        if (isSender) {
            info = info + " to " + transaction.getRecipient().getName() + "(id = " + transaction.getRecipient().getIdentifier();
        } else {
            info = info + " from " + transaction.getSender().getName() + "(id = " + transaction.getSender().getIdentifier();
        }
        info = info + ") for " + transaction.getTransferAmount();
        return info;
    }

    private static void add() {
        User user = AddUser.addUser(scanner);
        transactionsService.addUser(user);
        System.out.println("User with id = " + user.getIdentifier() + " is added");
    }
    private static void performTransfer() {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        try {
            int sender = scanner.nextInt();
            int recipient = scanner.nextInt();
            int Amount = scanner.nextInt();
            try {
                transactionsService.makeTransaction(sender, recipient, Amount);
                System.out.println("The transfer is completed");
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input. Expected a number");
                scanner.nextLine();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void printTransactions() {
        System.out.println("Enter a user ID");
        int id = 0;
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input. Expected a number");
            scanner.nextLine();
        }
        try {
            User user = transactionsService.getUser(id);
            AllTransactions.showTransactions(user);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void remove() {
        if (!dev) return;
        System.out.println("Enter a user ID and a transfer ID");
        int userId = 0;
        try {
            userId = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input. Expected a number");
            scanner.nextLine();
        }
        String transferIdString = scanner.next();
        UUID transferId;
        try {
            transferId = UUID.fromString(transferIdString);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }
        try {
            User user = transactionsService.getUser(userId);
            Transaction transaction = user.getTransaction().findTransaction(transferId);
            transactionsService.deleteTransactionsOfUser(userId, transferId);
            if (transaction.getTransferCategory() == Transaction.transferType.debits) {
                System.out.print("Transfer To " + transaction.getRecipient().getName() + "(id = " + transaction.getRecipient().getIdentifier() + ") ");
            } else {
                System.out.print("Transfer From " + transaction.getSender().getName() + "(id = " + transaction.getSender().getIdentifier() + ") ");
            }
            System.out.println(transaction.getTransferAmount() + " removed");
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }


}
