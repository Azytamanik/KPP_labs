package com.car.showroom.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Model data should be not empty!")
    private String model;
    @NotEmpty(message = "Color data should be not empty!")
    private String color;
    @NotNull(message = "Cost data should be not empty!")
    @Min(value = 0, message = "Cost should be greater that 0!")
    private int cost;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public Car() {
    }

    public Car(String model, String color, int cost) {
        this.model = model;
        this.color = color;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
