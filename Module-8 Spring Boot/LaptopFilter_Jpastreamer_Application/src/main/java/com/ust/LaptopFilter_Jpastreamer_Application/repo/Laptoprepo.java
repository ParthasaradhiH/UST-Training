package com.ust.LaptopFilter_Jpastreamer_Application.repo;

import com.ust.LaptopFilter_Jpastreamer_Application.model.Laptopinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Laptoprepo extends JpaRepository<Laptopinfo,Long> {
}
