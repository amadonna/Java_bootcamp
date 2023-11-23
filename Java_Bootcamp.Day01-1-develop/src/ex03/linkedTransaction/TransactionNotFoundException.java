package src.ex03.linkedTransaction;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String exception) {
        super(exception);
    }
}
