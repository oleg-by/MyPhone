package com.solvd.laba.interfaces.functional;

import com.solvd.laba.model.Gadget;

@FunctionalInterface
public interface ICompare<T extends Gadget, K extends Gadget> {
    String compareGadgets(T t, K k);
}
