package com.pharmaflow.pharmaflow.entity;

public enum Status {

    CREATED("CREATED", "Created"),
    VALIDATING("VALIDATING", "Validating"),
    CONFIRMED("CONFIRMED", "Confirmed"),
    SHIPPED("SHIPPED", "Shipped"),
    DELIVERED("DELIVERED", "Delivered"),
    CANCELLED("CANCELLED", "Cancelled");

    private final String code;
    private final String displayName;

    Status(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Status fromCode(String code) {
        for (Status status : Status.values()) {
            if (status.code.equalsIgnoreCase(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + code);
    }
}
