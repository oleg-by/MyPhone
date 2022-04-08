package main.java.com.solvd.laba.enums;

public enum Brand {
    APPLE("Apple"),
    SAMSUNG("Samsung"),
    XIAOMI("Xiaomi"),
    HUAWEI("Huawei"),
    ASUS("Asus"),
    SONY("Sony"),
    HONOR("Honor");

    private final String name;

    Brand(String name) {
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
