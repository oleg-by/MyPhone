package main.java.com.solvd.laba.enums;

public enum Color {
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    BLACK("black"),
    WHITE("white"),
    YELLOW("yellow"),
    SILVER("silver"),
    GREY("grey");

    private final String name;

    Color(String name) {
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
