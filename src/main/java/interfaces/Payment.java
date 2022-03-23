package main.java.interfaces;

import main.java.Transaction;
import main.java.TransactionException;

public interface Payment {
    void pay(Transaction transaction) throws TransactionException;
}
