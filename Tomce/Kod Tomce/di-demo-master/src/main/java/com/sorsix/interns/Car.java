package com.sorsix.interns;

import org.springframework.stereotype.Component;

/**
 * We annotated this class with @Component just to tell to ApplicationContext
 * due scanning to insert this class in the graph object as a bean.
 * Component is most abstract annotation in Spring(Everything is a component).
 * Components are denoted as beans and are thrown into ApplicationContext.
 */
@Component
public class Car {

    private final Transmission transmission;
    private final Engine engine;

    public Car(Transmission transmission, Engine engine) {
        this.transmission = transmission;
        this.engine = engine;
    }

    public int drive() {
        return engine.getPower() * 50;
    }

    @Override
    public String toString() {
        return "I'm a car with engine " + engine + " and trans " + transmission;
    }
}
