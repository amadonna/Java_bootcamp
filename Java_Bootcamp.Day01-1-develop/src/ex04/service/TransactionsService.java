package src.ex04.service;
import java.util.UUID;

import src.ex04.user.User;
import src.ex04.userArray.UsersArrayList;
import src.ex04.userArray.UsersList;
import src.ex04.trasaction.Transaction;
import src.ex04.linkedTransaction.TransactionsList;

public class TransactionsService {
    private UsersList usersArray;

    public TransactionsService() {
        usersArray = new UsersArrayList();
    }
    public void addUser(User user) {
        usersArray.addUser(user);
    }
    public double getUserBalance(User user) {
        return usersArray.getById(user.getIdentifier()).getBalance();
    }
    public void makeTransaction(int senderId, int recipientId, double amount) {
        MakeTransactions.makeTransactions(this.usersArray, senderId, recipientId, amount);
    }
    public Transaction[] getTransactionsOfUser(User user) {
        return this.usersArray.getById(user.getIdentifier()).getTransaction().toArray();
    }
    public void deleteTransactionsOfUser(int id, UUID identifier) {
        TransactionsList temp = this.usersArray.getById(id).getTransaction();
        temp.removeTransaction(identifier);
    }
    public Transaction[] unpairedTransaction() {
        return TransactionValid.transactionValid(usersArray);
    }

}
