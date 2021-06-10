package com.car.showroom.repositories;

import com.car.showroom.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {
    List<Car> findByModel(String model);
}
