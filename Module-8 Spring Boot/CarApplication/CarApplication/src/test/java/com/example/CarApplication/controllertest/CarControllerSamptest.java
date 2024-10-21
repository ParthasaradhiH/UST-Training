package com.example.CarApplication.controllertest;

import static org.mockito.Mockito.when;

import com.example.CarApplication.controller.Carcontroller;
import com.example.CarApplication.service.CarService;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {Carcontroller.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CarControllerSamptest {
    @MockBean
    private CarService carService;

    @Autowired
    private Carcontroller carcontroller;

    /**
     * Method under test: {@link Carcontroller#getAvailableCars()}
     */
    @Test
    public void testGetAvailableCars() throws Exception {
        when(carService.findAvailableCars()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/cars/available");
        MockMvcBuilders.standaloneSetup(carcontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    //find the modelname
    //create a car
    //list of model under brand
}
