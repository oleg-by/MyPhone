package main.java;

import main.java.interfaces.Payment;

public class ApplePay implements Payment {
    @Override
    public void pay(Transaction transaction) throws TransactionException {
        if(transaction == null){
            throw new TransactionException("The transaction is incorrect.");
        } else {
            System.out.println("The payment was successful through the Apple Pay system. " + transaction.toString());
        }
    }
}
