package fr.esgi.cleancode.exception;

public class vResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
