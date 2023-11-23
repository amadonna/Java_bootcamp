package src.ex05.trasaction;

public class IllegalTransactionException extends RuntimeException{
    public IllegalTransactionException(String message) {
        super(message);
    }
}