package main.java.com.solvd.laba.model;

import main.java.com.solvd.laba.exceptions.TransactionException;
import main.java.com.solvd.laba.interfaces.Payable;

public class ApplePay implements Payable {
    @Override
    public String pay(Transaction transaction) throws TransactionException {
        if(transaction == null){
            throw new TransactionException("The transaction is incorrect.");
        } else {
            return "The payment was successful through the Apple Pay system. " + transaction;
        }
    }
}
