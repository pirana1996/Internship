package com.sorsix.interns;


public class OtoEngine implements Engine {
    private final int power;

    public OtoEngine(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }
}
