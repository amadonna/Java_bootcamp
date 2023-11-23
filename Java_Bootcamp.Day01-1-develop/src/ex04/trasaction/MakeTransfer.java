package src.ex04.trasaction;

import src.ex04.user.User;

public class MakeTransfer {
    public static double setAmount(User sender, User recipient, double amount) {
        if (sender.getBalance() - amount < 0 || recipient.getBalance() + amount < 0) {
            throw new IllegalTransactionException("illegal amount");
        }
        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);
        return amount;
    }
}
