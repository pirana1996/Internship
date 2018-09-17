package com.sorsix.interns;

public class Transmission {
    private final String type;

    public Transmission(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "type='" + type + '\'' +
                '}';
    }
}
