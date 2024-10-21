package com.example.CarApplication.service;


import com.example.CarApplication.model.Car;
import com.example.CarApplication.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    //To find the available car
    public List<Car> findAvailableCars() {
        return carRepository.findByAvailable(true);
    }

    // Find car by model name
    public Car findCarByModelName(String modelname) {
        return carRepository.findByModelname(modelname);
    }

    // adding new car
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // Find model names by brand
    public List<String> findModelNamesByBrand(String brand) {
        List<Car> cars = carRepository.findByBrand(brand);
        return cars.stream()
                .map(Car::getModelname)
                .distinct() // Optional: to ensure unique model names
                .collect(Collectors.toList());
    }

}
