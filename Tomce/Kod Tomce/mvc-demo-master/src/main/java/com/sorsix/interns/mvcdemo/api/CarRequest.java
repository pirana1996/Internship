package com.sorsix.interns.mvcdemo.api;

import javax.validation.constraints.NotEmpty;

public class CarRequest {
    public String model;

    @NotEmpty
    public String make;

    @Override
    public String toString() {
        return model + " - " + make;
    }
}
