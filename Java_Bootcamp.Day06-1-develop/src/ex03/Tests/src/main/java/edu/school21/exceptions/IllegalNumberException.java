package edu.school21.exceptions;

public class IllegalNumberException extends RuntimeException {
    @Override
    public void printStackTrace() {
        System.out.println("Illegal argument");
    }
}
