package src.ex00;

import src.ex00.trasaction.Transaction;
import src.ex00.user.User;

public class Program {
    public static void showResults(Transaction transaction1) {
        System.out.println("Id :\t" + transaction1.getIdentifier());
        System.out.println("Recipient :\t" + transaction1.getRecipient().getName());
        System.out.println("Sender :\t" + transaction1.getSender().getName());
        System.out.println("Amount : \t" + transaction1.getTransferAmount());
        System.out.println("Category : \t" + transaction1.getTransferCategory());
    }
    public static void main (String[] args) {
        User user1 = new User(1,"Bolot", 15.3);
        User user2 = new User(2, "Bolot2", 12.3);
        User user3 = new User(2, "Bolot3", 254);
        User user4 = new User(2, "Bolot4", 41);
        Transaction transaction1 = new Transaction(user1, user2, 12);
        showResults(transaction1);
        transaction1.setSender(user3);
        showResults(transaction1);
        transaction1.setRecipient(user4);
        showResults(transaction1);
    }
}
