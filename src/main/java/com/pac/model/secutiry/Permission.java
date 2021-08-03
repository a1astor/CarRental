package com.pac.model.secutiry;

public enum Permission {
    READ("read"),
    WRITE("write"),
    UPDATE("update"),
    DELETE("delete");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
