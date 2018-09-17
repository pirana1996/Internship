package com.sorsix.interns;

public class ElectricEngine implements Engine {
    private final int power;

    public ElectricEngine(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }
}
