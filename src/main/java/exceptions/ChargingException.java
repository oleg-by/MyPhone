package main.java.exceptions;

public class ChargingException extends Exception {
    public ChargingException() {
    }

    public ChargingException(String message) {
        super(message);
    }

    public ChargingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChargingException(Throwable cause) {
        super(cause);
    }

    public ChargingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
