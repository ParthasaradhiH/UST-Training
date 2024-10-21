package com.example.CarApplication.controller;

import com.example.CarApplication.model.Car;
import com.example.CarApplication.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class Carcontroller {

    @Autowired
    private CarService carService;

    @GetMapping("/available")
    public ResponseEntity<List<Car>> getAvailableCars() {
        List<Car> availableCars = carService.findAvailableCars();
        return ResponseEntity.ok(availableCars);
    }

    @GetMapping("/model/{modelname}")
    public ResponseEntity<Car> getCarByModelName(@PathVariable String modelname) {
        Car car = carService.findCarByModelName(modelname);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car savedCar = carService.addCar(car);
        return ResponseEntity.ok(savedCar);
    }

    @GetMapping("/{brand}/models")
    public ResponseEntity<List<String>> getModelNamesByBrand(@PathVariable String brand) {
        List<String> modelNames = carService.findModelNamesByBrand(brand);
        return ResponseEntity.ok(modelNames);
    }


}

