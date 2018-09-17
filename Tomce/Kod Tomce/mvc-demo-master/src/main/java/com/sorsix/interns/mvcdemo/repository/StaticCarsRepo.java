package com.sorsix.interns.mvcdemo.repository;

import com.sorsix.interns.mvcdemo.model.Car;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Profile("dev")
public class StaticCarsRepo implements CarsRepository {
    private final List<Car> cars =
            Arrays.asList(new Car("Mazda", "CX-3"));

    public List<Car> getCars() {
        return cars;
    }
}