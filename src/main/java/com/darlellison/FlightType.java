package com.darlellison;

public enum FlightType {
    ECONOMY("Economy"),
    BUSINESS("Business");

    private final String label;

    FlightType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}
