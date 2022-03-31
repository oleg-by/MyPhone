package main.java.com.solvd.laba.exceptions;

public class BatteryException extends Exception {

    public BatteryException() {
    }

    public BatteryException(String message) {
        super(message);
    }

    public BatteryException(String message, Throwable cause) {
        super(message, cause);
    }

    public BatteryException(Throwable cause) {
        super(cause);
    }

    public BatteryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
