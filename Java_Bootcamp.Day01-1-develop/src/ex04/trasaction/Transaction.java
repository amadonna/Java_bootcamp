package src.ex04.trasaction;
import src.ex04.user.User;
import java.util.UUID;

import java.util.UUID;

public class Transaction {
    private final UUID identifier;
    private User recipient;
    private User sender;
    private transferType transferCategory;
    private double transferAmount;
    private enum transferType {debits, credits}

    public Transaction(User recipient, User sender, double amount) {
        identifier = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        setTransferAmount(amount);
        this.transferCategory = amount > 0 ? transferType.debits : transferType.credits;
    }

    public Transaction(Transaction transaction) {
        this.identifier = transaction.getIdentifier();
        this.sender = transaction.sender;
        this.recipient = transaction.recipient;
        this.transferAmount = transaction.transferAmount;
        this.transferCategory = transaction.transferCategory == transferType.credits ? transferType.debits : transferType.credits;
    }

    public UUID getIdentifier() {
        return identifier;
    }
    public User getRecipient() {
        return recipient;
    }
    public User getSender() {
        return sender;
    }
    public double getTransferAmount() {
        return transferAmount;
    }
    public transferType getTransferCategory() {
        return transferCategory;
    }
    public void setRecipient(User recipient) {
        recipient.setBalance(recipient.getBalance() + this.transferAmount);
        this.recipient = recipient;
    }
    public void setSender (User sender) {
        sender.setBalance(sender.getBalance() - this.transferAmount);
        this.sender = sender;
    }
    public void setTransferAmount(double amount) {
        this.transferAmount = MakeTransfer.setAmount(this.sender, this.recipient, amount);
    }

}
