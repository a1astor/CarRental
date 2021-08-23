package com.pac.model;

public enum TransmissionType {

    /**
     * Automatic Transmission.
     */
    AT("AT"),

    /**
     * Manual Transmission.
     */
    MT("MT"),

    /**
     * AUTOMATED_MANUAL_TRANSMISSION.
     */
    AM("AM"),

    /**
     * CONTINUOUSLY_VARIABLE_TRANSMISSION.
     */
    CVT("CVT");

    private String name;

    TransmissionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
