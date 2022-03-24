package main.java;

import main.java.interfaces.Payable;

public class SamsungPay implements Payable {
    @Override
    public String pay(Transaction transaction) throws TransactionException {
        if(transaction == null){
            throw new TransactionException("The transaction is incorrect.");
        } else {
            return "The payment was successful through the Samsung Pay system. " + transaction.toString();
        }
    }
}
