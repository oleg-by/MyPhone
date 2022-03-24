package main.java.interfaces;

import main.java.Transaction;
import main.java.TransactionException;

public interface Payable {
    String pay(Transaction transaction) throws TransactionException;
}
