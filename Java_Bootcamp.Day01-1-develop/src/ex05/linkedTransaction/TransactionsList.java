package src.ex05.linkedTransaction;

import src.ex05.trasaction.Transaction;

import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);
    boolean removeTransaction(UUID id);
    Transaction[] toArray();
    Transaction findTransaction(UUID id);
}
