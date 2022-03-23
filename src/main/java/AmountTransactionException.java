package main.java;

public class AmountTransactionException extends Exception {
    public AmountTransactionException() {
    }

    public AmountTransactionException(String message) {
        super(message);
    }

    public AmountTransactionException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountTransactionException(Throwable cause) {
        super(cause);
    }

    public AmountTransactionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
