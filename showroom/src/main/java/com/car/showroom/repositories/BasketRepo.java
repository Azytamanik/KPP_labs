package com.car.showroom.repositories;

import com.car.showroom.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepo extends JpaRepository<Basket, Long> {
}
