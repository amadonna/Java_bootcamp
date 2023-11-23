package src.ex04.linkedTransaction;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String exception) {
        super(exception);
    }
}
