package main.java.com.solvd.laba.interfaces.functional;

import main.java.com.solvd.laba.model.Gadget;
import main.java.com.solvd.laba.model.Phone;

@FunctionalInterface
public interface ICompare<T extends Gadget, K extends Gadget> {
    String compareGadgets(T t, K k);
}
