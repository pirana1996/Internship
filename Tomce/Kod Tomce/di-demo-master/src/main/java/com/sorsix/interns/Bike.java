package com.sorsix.interns;

import org.springframework.stereotype.Component;

@Component
public class Bike {

    private final Transmission transmission;

    public Bike(Transmission transmission) {
        this.transmission = transmission;
    }

    public Transmission getTransmission() {
        return transmission;
    }
}
