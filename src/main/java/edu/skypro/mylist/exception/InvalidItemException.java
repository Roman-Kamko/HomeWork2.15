package edu.skypro.mylist.exception;

public class InvalidItemException extends RuntimeException {
    public InvalidItemException() {
    }

    public InvalidItemException(String message) {
        super(message);
    }
}
