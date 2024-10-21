package com.example.CarApplication.repositorytest;

import com.example.CarApplication.model.Car;
import com.example.CarApplication.repository.CarRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;

    @Test
    public void testFindByAvailable() {
        Car car1=new Car(1,"Toyota","grandvitra",true);
        Car car2=new Car(2,"Honda","cvdc",false);
        Car car3=new Car(3, "BMW", "x5", true);
        carRepository.saveAll(Arrays.asList(car1,car2,car3));
        List<Car> availableCars = carRepository.findByAvailable(true);
        Assert.assertEquals(2, availableCars.size());
        Assert.assertEquals("Toyota", availableCars.get(0).getBrand());

    }
}