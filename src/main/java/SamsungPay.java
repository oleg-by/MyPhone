package main.java;

import main.java.interfaces.Payment;

public class SamsungPay implements Payment {
    @Override
    public void pay(Transaction transaction) throws TransactionException {
        if(transaction == null){
            throw new TransactionException("The transaction is incorrect.");
        } else {
            System.out.println("The payment was successful through the Samsung Pay system. " + transaction.toString());
        }
    }
}
