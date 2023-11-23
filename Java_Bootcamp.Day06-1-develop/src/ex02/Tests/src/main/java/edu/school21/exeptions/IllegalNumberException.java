package edu.school21.exeptions;

public class IllegalNumberException extends RuntimeException {
    @Override
    public void printStackTrace() {
        System.out.println("Illegal argument");
    }
}
