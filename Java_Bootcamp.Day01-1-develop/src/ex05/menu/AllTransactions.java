package src.ex05.menu;

import src.ex05.trasaction.Transaction;
import src.ex05.user.User;

public class AllTransactions {
    public static void showTransactions(User user) {
        Transaction[] transactions = user.getTransaction().toArray();
        for (Transaction t : transactions) {
            if (t.getTransferCategory() == Transaction.transferType.debits) {
                System.out.print("To " + t.getRecipient().getName());
            } else {
                System.out.print("From " + t.getSender().getName());
            }
            System.out.print("(" + t.getRecipient().getIdentifier() + ")");
            if (t.getTransferCategory() == Transaction.transferType.debits) {
                System.out.print(" -");
            } else {
                System.out.print(" ");
            }
            System.out.print(t.getTransferAmount() + " ");
            System.out.print(" with id = ");
            System.out.println(t.getIdentifier());
        }
    }
}
