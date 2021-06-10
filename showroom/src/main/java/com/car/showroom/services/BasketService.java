package com.car.showroom.services;

import com.car.showroom.models.Basket;
import com.car.showroom.models.Car;

public class BasketService {
    public static void addCar(Basket basket,Car car){
        basket.getCars().add(car);
    }
}
