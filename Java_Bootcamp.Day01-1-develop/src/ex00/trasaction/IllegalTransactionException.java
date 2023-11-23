package src.ex00.trasaction;

public class IllegalTransactionException extends RuntimeException{
    public IllegalTransactionException(String message) {
        super(message);
    }
}