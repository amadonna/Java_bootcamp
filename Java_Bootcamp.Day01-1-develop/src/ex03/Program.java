package src.ex03;

import src.ex03.linkedTransaction.TransactionsLinkedList;
import src.ex03.linkedTransaction.TransactionsList;
import src.ex03.trasaction.Transaction;
import src.ex03.user.User;

public class Program {
    public static void main(String[] args) {
        User sender1 = new User("Bolot_1", 110.3);
        User sender2 = new User("Bolot_2", 120.3);
        User sender3 = new User("Bolot_3", 130.3);
        User res1 = new User("Bolot_4", 140.3);
        User res2 = new User("Bolot_5", 150.3);
        User res3 = new User("Bolot_5", 160.3);

        Transaction t1 = new Transaction(res1, sender1, -20);
        Transaction t2 = new Transaction(res2, sender2, 60);
        Transaction t3 = new Transaction(res3, sender3, -40);
        TransactionsList tList = new TransactionsLinkedList();
        tList.addTransaction(t1);
        tList.addTransaction(t2);
        tList.addTransaction(t3);
        for (Transaction t : tList.toArray()) {
            System.out.println("id: " + t.getIdentifier() + " | S : " + t.getSender().getName() + " " + t.getSender().getBalance() + " | R: " + t.getRecipient().getName() + " " + t.getRecipient().getBalance() + " | " + t.getTransferAmount() + " | " + t.getTransferCategory());
        }
        tList.removeTransaction(t1.getIdentifier());
        System.out.println("after remove");
        for (Transaction t : tList.toArray()) {
            System.out.println("id: " + t.getIdentifier() + " | S : " + t.getSender().getName() + " | R: " + t.getRecipient().getName() + " | " + t.getTransferAmount() + " | " + t.getTransferCategory());
        }
    }
}
