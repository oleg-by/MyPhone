package main.java.com.solvd.laba.exceptions;

public class CallerIDException extends Exception {
    public CallerIDException() {
    }

    public CallerIDException(String message) {
        super(message);
    }

    public CallerIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public CallerIDException(Throwable cause) {
        super(cause);
    }

    public CallerIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
