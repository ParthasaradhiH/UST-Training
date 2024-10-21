package com.example.CarApplication.repository;

import com.example.CarApplication.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findByAvailable(boolean b);
    Car findByModelname(String modelname);
    List<Car> findByBrand(String brand);
}