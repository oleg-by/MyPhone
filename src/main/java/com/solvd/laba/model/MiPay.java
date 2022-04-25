package com.solvd.laba.model;

import com.solvd.laba.exceptions.TransactionException;
import com.solvd.laba.interfaces.Payable;

public class MiPay implements Payable {
    @Override
    public String pay(Transaction transaction) throws TransactionException {
        if(transaction == null){
            throw new TransactionException("The transaction is incorrect.");
        } else {
            return "The payment was successful through the Mi Pay system. " + transaction;
        }
    }
}
