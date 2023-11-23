package src.ex04.service;
import src.ex04.userArray.UsersList;
import src.ex04.trasaction.Transaction;

public class MakeTransactions {
    public static void makeTransactions(UsersList usersArray, int senderId, int recipientId, double amount) {
        Transaction transactionFromSender = new Transaction(usersArray.getById(recipientId), usersArray.getById(senderId), amount);
        Transaction transactionFromRecipient = new Transaction(transactionFromSender);
        usersArray.getById(senderId).setTransactionsList(transactionFromSender);
        usersArray.getById(recipientId).setTransactionsList(transactionFromRecipient);
    }
}
