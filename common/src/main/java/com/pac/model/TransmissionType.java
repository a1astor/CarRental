package com.pac.model;

public enum TransmissionType {

    AT("AT"),

    MT("MT"),

    AUTOMATED_MANUAL_TRANSMISSION("AM"),

    CONTINUOUSLY_VARIABLE_TRANSMISSION("CVT");

    private String name;

    TransmissionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
