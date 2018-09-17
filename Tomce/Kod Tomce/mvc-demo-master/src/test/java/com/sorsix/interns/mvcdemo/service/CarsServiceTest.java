package com.sorsix.interns.mvcdemo.service;

import com.sorsix.interns.mvcdemo.model.Car;
import com.sorsix.interns.mvcdemo.repository.CarsRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;


/**
 * When you use DI in service, it's not a unit test.
 * This is integration test, and when runs it's starts
 * and loads full Spring context.
 */
public class CarsServiceTest {

    CarsService service;

    @Before
    public void setup() {
        service = new CarsService(() -> Arrays.asList(
                new Car("BMW", ""),
                new Car("Mazda", ""),
                new Car("Zastava", "")
        ));
    }
    @Test
    public void test_get_cars() {
        List<Car> actual = service.getCars();
        assertEquals(1, actual.size());
    }
}