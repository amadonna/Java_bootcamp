package src.ex02.user;

public class User {
    private final int identifier;
    private String name;
    private double balance;

    public User(String nameUser, double balanceOfUser) {
        this.identifier = UserIdsGenerator.getInstance().generatedId();
        this.name = nameUser;
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

}
