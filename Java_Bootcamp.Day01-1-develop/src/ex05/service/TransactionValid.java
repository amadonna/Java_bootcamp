package src.ex05.service;

import src.ex05.linkedTransaction.TransactionsLinkedList;
import src.ex05.linkedTransaction.TransactionsList;
import src.ex05.trasaction.Transaction;
import src.ex05.userArray.UsersList;

import java.util.UUID;

public class TransactionValid {

    public static Transaction[] transactionValid(UsersList usersList) {
        TransactionsList transactionsList = new TransactionsLinkedList();
        for (int i = 0; i < usersList.getCountOfUsers(); i++) {
            Transaction[] userTransactions = usersList.getByIndex(i).getTransaction().toArray();
            for (Transaction transaction : userTransactions) {
                if (!findPair(usersList, transaction.getIdentifier(), i)){
                    transactionsList.addTransaction(transaction);
                }
            }
        }
        return transactionsList.toArray();
    }
    private static boolean findPair(UsersList usersList, UUID id, int index) {
        for (int i = 0; i < usersList.getCountOfUsers(); i++) {
            for (Transaction t : usersList.getByIndex(i).getTransaction().toArray()) {
                if (i != index && t.getIdentifier().equals(id)) return true;
            }
        }
        return false;
    }
}
