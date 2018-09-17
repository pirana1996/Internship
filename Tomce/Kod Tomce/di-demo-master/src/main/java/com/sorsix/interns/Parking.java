package com.sorsix.interns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parking {

    private final Car car;

    @Autowired(required = false)
    private Bike bike;

    public Parking(Car car) {
        this.car = car;
    }


}
