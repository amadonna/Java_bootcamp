package src.ex03.trasaction;

public class IllegalTransactionException extends RuntimeException{
    public IllegalTransactionException(String message) {
        super(message);
    }
}