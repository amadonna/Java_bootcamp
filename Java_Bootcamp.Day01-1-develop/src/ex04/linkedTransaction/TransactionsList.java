package src.ex04.linkedTransaction;

import src.ex04.trasaction.Transaction;

import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);
    boolean removeTransaction(UUID id);
    Transaction[] toArray();
}
