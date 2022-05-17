package com.solvd.laba.enums;

public enum AccountType {
    ADMIN("admin"),
    USER("user");

    private final String type;

    AccountType(String type) {
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
