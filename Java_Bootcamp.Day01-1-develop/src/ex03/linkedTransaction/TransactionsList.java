package src.ex03.linkedTransaction;
import src.ex03.trasaction.Transaction;

import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);
    boolean removeTransaction(UUID id);
    Transaction[] toArray();
}
