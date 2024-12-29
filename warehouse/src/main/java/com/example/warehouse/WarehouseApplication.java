package com.example.warehouse;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WarehouseApplication implements CommandLineRunner {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public static void main(String[] args) {
        SpringApplication.run(WarehouseApplication.class, args);
    }

    @Override
    @LogExecutionTime
    public void run(String... args) throws Exception {
        if (warehouseRepository.count() == 0) {
            Set<Product> products = new HashSet<>();
            products.add(new Product("Product 1", "Description 1", 10.0));
            products.add(new Product("Product 2", "Description 2", 20.0));

            Warehouse warehouse = new Warehouse("Warehouse 1", "Location 1", products);

            warehouseRepository.save(warehouse);
        }
    }
}