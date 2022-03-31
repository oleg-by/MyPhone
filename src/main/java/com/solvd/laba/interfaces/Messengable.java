package main.java.com.solvd.laba.interfaces;

import main.java.com.solvd.laba.model.Caller;

public interface Messengable {
    default String sendMessage(String message, Caller caller){
        return "The message (" + message + ") has been sent to subscriber " + caller.getName() + " at number " + caller.getCallerID() + ".";
    }
    default String getMessage(Caller caller){
        return "You have received a message from " + caller.getName();
    }
}
