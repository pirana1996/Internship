package com.sorsix.interns.mvcdemo.api;

import com.sorsix.interns.mvcdemo.model.Car;
import com.sorsix.interns.mvcdemo.service.CarsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private final CarsService service;

    public CarsController(CarsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Car> getCars() {
        return service.getCars();
    }

    @GetMapping("/custom/{model}")
    public Map<String, Object> getCustom(@PathVariable Long model,
                                         @RequestParam String make) {
        Map<String, Object> car = new HashMap<>();
        car.put("make", make);
        car.put("model", model);
        return car;
    }

    @PostMapping("/post")
    public Car postCar(@RequestBody @Valid CarRequest car) {
        System.out.println(car);
        return new Car(car.make, car.model);
    }
}
