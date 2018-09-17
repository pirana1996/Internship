package com.sorsix.interns.mvcdemo.api;

import com.sorsix.interns.mvcdemo.model.Car;
import com.sorsix.interns.mvcdemo.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileReader;
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
    public List<Car> getCar() {
//        return "{\"type\": \"Car\"}";
        return Arrays.asList(new Car("Mazda", "CX-3"));
    }

    @GetMapping("/custom/{model}")
    public Map<String, Object> getCustom(@PathVariable String model, @RequestParam String make) {
        Map<String, Object> car = new HashMap<>();
        car.put("make", make);
        car.put("model", model);
        return car;
    }

    /*
    @PostMapping("/post")
    public Map<String, Object> postCar(HttpServletRequest request) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String lines = reader.lines().collect(Collectors.joining());
        System.out.println("lines: " + lines);
        return Collections.singletonMap("car", 10);
    }*/


    /*
    @PostMapping("/post")
    public Map<String, Object> postCar(@RequestBody Map<String, Object> request) throws IOException {
        System.out.println("lines: " + request);
        return Collections.singletonMap("car", 10);
    }
    */

    @PostMapping("/post")
    public Map<String, Object> postCar(@RequestBody String request) throws IOException {
        System.out.println("lines: " + request);
        return Collections.singletonMap("car", 10);
    }
}
