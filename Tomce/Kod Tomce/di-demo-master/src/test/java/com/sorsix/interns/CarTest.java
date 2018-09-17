package com.sorsix.interns;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    Car car;

    @Before
    public void setup() {
        /**
         * Easy testability means that we can test our class(controller, service, etc..)
         * without having dependencies on other components.
         * Bellow is single example:
         * -car object with mock engine.
         * We shouldn't know nothing about engines, we know which attitudes
         * are proper for engines and that is all we should care about.
         *
         * We use this way because sometimes it is not adequate to test some components
         * because of complexity of model creation(cause of their tightly coupled).
         * That's in cases where we have some complicated functionality which depends
         * on some responses of servers or etc.
         * In that way our component is not testable. That's why we use loosely coupling
         * with a combination of Dependency injection.
         * In this case we don't use Spring DI we just use simple DI. Because the use of
         * Spring DI will acquire building of a Spring Context - which is not case in JUnit tests.
         */
        car = new Car(new Transmission("auto"), () -> 10);
    }

    @Test
    public void drive_test() {
        int actual = car.drive();
        assertEquals(500, actual);
    }
}