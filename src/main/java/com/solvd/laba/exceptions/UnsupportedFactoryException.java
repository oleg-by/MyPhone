package com.solvd.laba.exceptions;

public class UnsupportedFactoryException extends Exception {
    public UnsupportedFactoryException() {
    }

    public UnsupportedFactoryException(String message) {
        super(message);
    }

    public UnsupportedFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedFactoryException(Throwable cause) {
        super(cause);
    }

    public UnsupportedFactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
