package src.ex05.user;
import src.ex05.linkedTransaction.TransactionsLinkedList;
import src.ex05.linkedTransaction.TransactionsList;
import src.ex05.trasaction.Transaction;

public class User {
    private final int identifier;
    private String name;
    private double balance;
    private final TransactionsList transactions;

    public User(String nameUser, double balanceOfUser) {
        this.identifier = UserIdsGenerator.getInstance().generatedId();
        this.name = nameUser;
        this.transactions = new TransactionsLinkedList();
        setBalance(balanceOfUser);
    }
    public int getIdentifier() {
        return identifier;
    }
    public String getName() {
        return name;
    }
    public double getBalance () {
        return balance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(double balance) {
        this.balance = initBalance.checkBalance(balance);
    }
    public void setTransactionsList(Transaction transactions) {
        this.transactions.addTransaction(transactions);
    }
    public TransactionsList getTransaction() {
        return this.transactions;
    }

}
