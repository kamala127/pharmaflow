package com.pharmaflow.pharmaflow.entity;

public enum Role {

    ADMIN("ROLE_ADMIN"),
    DISTRIBUTOR("ROLE_DISTRIBUTOR"),
    WAREHOUSE("ROLE_WAREHOUSE");

    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
