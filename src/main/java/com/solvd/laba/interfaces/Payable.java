package main.java.com.solvd.laba.interfaces;

import main.java.com.solvd.laba.model.Transaction;
import main.java.com.solvd.laba.exceptions.TransactionException;

public interface Payable {
    String pay(Transaction transaction) throws TransactionException;
}
