package com.ust.LaptopFilter_Jpastreamer_Application.controller;

import com.ust.LaptopFilter_Jpastreamer_Application.model.Laptopinfo;
import com.ust.LaptopFilter_Jpastreamer_Application.service.Laptopservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/ust")
public class Laptopcontroller {

    @Autowired
    private Laptopservice service;

    @PostMapping("/addlaptop")
    public Laptopinfo addLaptopinfo(@RequestBody Laptopinfo info) {
        return service.addnewlaptop(info);
    }
    @GetMapping("/getlaptop")
    public List<Laptopinfo> getLaptopinfo(){
        return service.getalllaptop();
    }

    @GetMapping("/filter-by-price")
    public List<Laptopinfo> getLaptopsByPrice(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return service.findByPrice(minPrice, maxPrice);
    }

    @GetMapping("/filter-by-brand")
    public List<Laptopinfo> getLaptopsByBrand(@RequestParam String brand) {
        return service.findByBrand(brand);
    }

    @GetMapping("/filter-by-usage")
    public List<Laptopinfo> getLaptopsByPurpose(@RequestParam String purpose) {
        return service.findByPurpose(purpose);
    }

}
