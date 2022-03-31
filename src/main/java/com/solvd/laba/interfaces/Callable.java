package main.java.com.solvd.laba.interfaces;

import main.java.com.solvd.laba.model.Caller;

public interface Callable {
    default void calling(Caller caller) {
        System.out.println("Outgoing call to " + caller.getName() + " at number " + caller.getCallerID() + "...");
    }
}
