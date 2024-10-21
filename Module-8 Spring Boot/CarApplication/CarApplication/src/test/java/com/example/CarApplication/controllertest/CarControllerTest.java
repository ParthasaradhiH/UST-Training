//package com.example.CarApplication.controllertest;
//
//import com.example.CarApplication.controller.Carcontroller;
//import com.example.CarApplication.model.Car;
//import com.example.CarApplication.service.CarService;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import java.util.Collections;
//
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@WebMvcTest(Carcontroller.class)
//public class CarControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private CarService carService;
//
//    @Test
//    public void testGetAvailableCars() throws Exception {
//
//        Car car1 = new Car(1, "Toyota", "grandvitra", true);
//        when(carService.findAvailableCars()).thenReturn(Collections.singletonList(car1));
//
//        mockMvc.perform(get("/api/cars/available"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].modelname").value("grandvitra"));
//
//    }
//
//
//}