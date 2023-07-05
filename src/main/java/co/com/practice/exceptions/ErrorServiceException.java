package co.com.practice.exceptions;

public class ErrorServiceException extends RuntimeException {
    public ErrorServiceException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
