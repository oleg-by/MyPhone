package main.java.model;

import main.java.exceptions.TransactionException;
import main.java.interfaces.Payable;

public class MiPay implements Payable {
    @Override
    public String pay(Transaction transaction) throws TransactionException {
        if(transaction == null){
            throw new TransactionException("The transaction is incorrect.");
        } else {
            return "The payment was successful through the Mi Pay system. " + transaction.toString();
        }
    }
}