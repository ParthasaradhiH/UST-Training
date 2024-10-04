package com.ust.LaptopFilter_Jpastreamer_Application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "laptopinfo")
public class Laptopinfo {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String brand;
    private String model;
    private String purpose;
}
