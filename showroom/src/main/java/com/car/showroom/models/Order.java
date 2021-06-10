package com.car.showroom.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity(name = "ordr")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @Temporal(TemporalType.DATE)
    private final java.util.Calendar orderDate;

    private int carsCount;
    private int carsAmount;

    @OneToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public Order(Basket basket) {
        this.basket = basket;
        orderDate = Calendar.getInstance();
        orderDate.getTime();
        carsCount = basket.getCars().size();
        for (Car car : basket.getCars()) {
            carsAmount += car.getCost();
        }
    }

    public Order() {
        orderDate = Calendar.getInstance();
        orderDate.getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public int getCarsCount() {
        return carsCount;
    }

    public void setCarsCount(int carsCount) {
        this.carsCount = carsCount;
    }

    public int getCarsAmount() {
        return carsAmount;
    }

    public void setCarsAmount(int carsAmount) {
        this.carsAmount = carsAmount;
    }
}
