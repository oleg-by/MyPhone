package main.java.com.solvd.laba.enums;

public enum GadgetType {
    PHONE("phone"),
    WATCH("watch"),
    TABLET("tablet"),
    HEADPHONES("headphones"),
    SMART_SPEAKER("smart speaker"),
    POWER_BANK("power bank"),
    PORTABLE_SPEAKER("portable speaker");

    private final String type;

    GadgetType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
