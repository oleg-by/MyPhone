package main.java.com.solvd.laba.enums;

public enum GadgetBrand {
    APPLE("Apple"),
    SAMSUNG("Samsung"),
    XIAOMI("Xiaomi"),
    HUAWEI("Huawei"),
    ASUS("Asus"),
    SONY("Sony"),
    HONOR("Honor");

    private final String name;

    GadgetBrand(String name) {
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
