package com.sorsix.interns.mvcdemo.service;

import com.sorsix.interns.mvcdemo.model.Car;
import com.sorsix.interns.mvcdemo.repository.CarsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {
    private final CarsRepo carsRepo;

    public CarsService(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }

    public List<Car> getCars() {
        return carsRepo.getCars();
    }
}
