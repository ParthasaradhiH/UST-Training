package com.ust.LaptopFilter_Jpastreamer_Application.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.LaptopFilter_Jpastreamer_Application.model.Laptopinfo;
import com.ust.LaptopFilter_Jpastreamer_Application.repo.Laptoprepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class Laptopservice {

    @Autowired
    private Laptoprepo repo;

//    private final JPAStreamer jpaStreamer;
//
//    @Autowired
//    public Laptopservice(final JPAStreamer jpaStreamer) {
//        this.jpaStreamer = jpaStreamer;
//    }

    public Laptopinfo addnewlaptop(Laptopinfo info) {
        return repo.save(info);
    }

    public List<Laptopinfo> getalllaptop() {
        return repo.findAll();
    }

    public List<Laptopinfo> findByPrice(double minPrice, double maxPrice) {
        return repo.findAll().stream()
                .filter(laptop -> laptop.getPrice() >= minPrice && laptop.getPrice() <= maxPrice)
                .toList();
    }

    public List<Laptopinfo> findByBrand(String brand) {
        return repo.findAll().stream()
                .filter(laptop -> laptop.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    public List<Laptopinfo> findByPurpose(String purpose) {
        return repo.findAll().stream()
                .filter(laptop -> laptop.getPurpose().equalsIgnoreCase(purpose))
                .toList();
    }
}
