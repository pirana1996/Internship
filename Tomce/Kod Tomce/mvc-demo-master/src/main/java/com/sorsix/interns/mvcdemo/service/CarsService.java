package com.sorsix.interns.mvcdemo.service;

import com.sorsix.interns.mvcdemo.model.Car;
import com.sorsix.interns.mvcdemo.repository.CarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsService {

    private final CarsRepository repo;

    public CarsService(CarsRepository repo) {
        this.repo = repo;
    }

    public List<Car> getCars() {
        List<Car> cars = repo.getCars();
        return cars.stream()
                .filter(car -> car.getMake().length() <= 20)
                .collect(Collectors.toList());

    }
}
