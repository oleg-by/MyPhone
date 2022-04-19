package main.java.com.solvd.laba.enums;

public enum GadgetModel {
    I13PROMAX("Iphone 13 PRO MAX"),
    IPADPRO("iPad Pro"),
    WATCHS7("Watch Series 7"),
    GALAXYS22U("Galaxy S22 Ultra"),
    MI11U("Mi 11 Ultra"),
    P50PRO("P50 Pro"),
    XPERIAPROI("Xperia Pro-I"),
    H30PRO("30 Pro+");

    private final String name;

    GadgetModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
