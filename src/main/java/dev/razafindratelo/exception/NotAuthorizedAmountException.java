package dev.razafindratelo.exception;

public class NotAuthorizedAmountException extends RuntimeException {
    public NotAuthorizedAmountException(String message) {
        super(message);
    }
}
