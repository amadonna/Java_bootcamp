package src.ex05.service;
import src.ex05.trasaction.Transaction;
import src.ex05.userArray.UsersList;

public class MakeTransactions {
    public static void makeTransactions(UsersList usersArray, int senderId, int recipientId, double amount) {
        Transaction transactionFromSender = new Transaction(usersArray.getById(recipientId), usersArray.getById(senderId), amount);
        Transaction transactionFromRecipient = new Transaction(transactionFromSender);
        usersArray.getById(senderId).setTransactionsList(transactionFromSender);
        usersArray.getById(recipientId).setTransactionsList(transactionFromRecipient);
    }
}
