package com.solvd.laba.interfaces;

import com.solvd.laba.model.Caller;

public interface Callable {
    default String calling(Caller caller) {
        return "Outgoing call to " + caller.getName() + " at number " + caller.getCallerID() + "...";
    }
}
