package main.java.interfaces;

import main.java.model.Transaction;
import main.java.exceptions.TransactionException;

public interface Payable {
    String pay(Transaction transaction) throws TransactionException;
}
