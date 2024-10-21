package com.example.CarApplication.servicetest;


import com.example.CarApplication.model.Car;
import com.example.CarApplication.repository.CarRepository;
import com.example.CarApplication.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarServiceTest {
    @Autowired
    private CarService carService;
    @MockBean
    private CarRepository carRepository;

    @Test
    public void testFindAvailableCars(){
        Car car = new Car(1,"Toyota","grandvitra",true);
        when(carRepository.findByAvailable(true)).thenReturn(Collections.singletonList(car));
        List<Car> availableCars = carService.findAvailableCars();
        assertEquals(1,availableCars.size());
        assertEquals(car, availableCars.get(0));

    }


}
