package com.sorsix.interns.mvcdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private final String make;
    private final String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    @JsonIgnore
    public String getMake() {
        return make;
    }

    @JsonProperty("the_model")
    public String getModel() {
        return model;
    }

    public String getMakeUppercase() {
        return make.toUpperCase();
    }

    @JsonProperty
    public int power() {
        return 100;
    }
}
