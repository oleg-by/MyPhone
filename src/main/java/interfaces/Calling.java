package main.java.interfaces;

import main.java.Caller;

public interface Calling {
    default void calling(Caller caller) {
        System.out.println("Outgoing call to " + caller.getName() + " at number " + caller.getCallerID() + "...");
    }
}
