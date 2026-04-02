package com.pharmaflow.pharmaflow.entity;

public enum NotificationType {

    ORDER_CREATED("Order Created"),
    ORDER_CONFIRMED("Order Confirmed"),
    ORDER_SHIPPED("Order Shipped"),
    ORDER_DELIVERED("Order Delivered"),
    ORDER_CANCELLED("Order Cancelled"),
    STOCK_ALERT("Stock Alert");

    private final String displayName;

    NotificationType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
