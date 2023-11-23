package src.ex04;
import src.ex04.service.TransactionsService;
import src.ex04.user.User;


public class Program {
    public static void main (String[] args) {
        User user1 = new User("bolot1", 150.02);
        User user2 = new User("bolot2", 412.2);
        TransactionsService transactionsService = new TransactionsService();
        transactionsService.addUser(user1);
        transactionsService.addUser(user2);
        System.out.println(transactionsService.getUserBalance(user1));
        System.out.println(user1.getName() + " " + user1.getBalance() );
        System.out.println(user2.getName() + " " + user2.getBalance() );
        transactionsService.makeTransaction(user1.getIdentifier(), user2.getIdentifier(), 50);
        System.out.println(user1.getName() + " " + user1.getBalance() + " " + user1.getTransaction().toArray()[0].getTransferCategory());
        System.out.println(user2.getName() + " " + user2.getBalance() + " " + user2.getTransaction().toArray()[0].getTransferCategory());
        transactionsService.deleteTransactionsOfUser(user1.getIdentifier(), user1.getTransaction().toArray()[0].getIdentifier());
        System.out.println(transactionsService.unpairedTransaction()[0].getIdentifier());
    }
}
