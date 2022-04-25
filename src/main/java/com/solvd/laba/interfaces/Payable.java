package com.solvd.laba.interfaces;

import com.solvd.laba.exceptions.TransactionException;
import com.solvd.laba.model.Transaction;

public interface Payable {
    String pay(Transaction transaction) throws TransactionException;
}
