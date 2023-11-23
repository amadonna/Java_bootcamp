package src.ex05.service;

import src.ex05.linkedTransaction.TransactionsList;
import src.ex05.trasaction.Transaction;
import src.ex05.user.User;
import src.ex05.userArray.UsersArrayList;
import src.ex05.userArray.UsersList;

import java.util.UUID;

public class TransactionsService {
    private UsersList usersArray;

    public TransactionsService() {
        usersArray = new UsersArrayList();
    }
    public boolean addUser(User user) {
        usersArray.addUser(user);
        return usersArray.getById(user.getIdentifier()) == user;
    }
    public User getUser(int id) {
        return usersArray.getById(id);
    }
    public double getUserBalance(int id) {
        return usersArray.getById(usersArray.getById(id).getIdentifier()).getBalance();
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
