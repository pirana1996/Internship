package com.sorsix.interns.mvcdemo.model;


public class Car {
    private final String make;
    private final String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    /**
     * if we don't have getters
     * No converter found for return value of type: class com.sorsix.interns.mvcdemo.model.Car
     */
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}
