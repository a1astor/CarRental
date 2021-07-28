package com.pac.model.utilsclass;

public enum TransmissionType {

    AUTOMATIC_TRANSMISSION("AT"),

    MANUAL_TRANSMISSION("MT"),

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
