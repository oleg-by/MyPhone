package main.java.com.solvd.laba.enums;

public enum Brand {
    APPLE("Apple"),
    SAMSUNG("Samsung"),
    XIAOMI("Xiaomi"),
    HUAWEI("Huawei"),
    ASUS("Asus"),
    SONY("Sony"),
    HONOR("Honor");

    private final String brand;

    Brand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return brand;
    }
}
