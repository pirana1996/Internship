package com.sorsix.interns.mvcdemo.repository;

import com.sorsix.interns.mvcdemo.model.Car;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Profile("prod")
public class DbRepository implements CarsRepository {

    @Override
    public List<Car> getCars() {
        return Collections.emptyList();
    }
}
