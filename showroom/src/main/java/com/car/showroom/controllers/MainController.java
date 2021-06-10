package com.car.showroom.controllers;

import com.car.showroom.models.Basket;
import com.car.showroom.models.Car;
import com.car.showroom.models.Order;
import com.car.showroom.repositories.BasketRepo;
import com.car.showroom.repositories.CarRepo;
import com.car.showroom.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private final CarRepo carRepo;
    private final BasketRepo basketRepo;
    private final OrderRepo orderRepo;

    @Autowired
    public MainController(CarRepo carRepo, BasketRepo basketRepo, OrderRepo orderRepo) {
        this.carRepo = carRepo;
        this.basketRepo = basketRepo;
        this.orderRepo = orderRepo;
    }

    @GetMapping({"/", "/drop", "/add"})
    public String main(@RequestParam(required = false, defaultValue = "") String filter,
                       Model model) {
        List<Car> cars;

        if (filter != null && !filter.isEmpty()) {
            cars = carRepo.findByModel(filter);
        } else {
            cars = carRepo.findAll();
        }

        if (!(basketRepo.existsById(1L))){
            Basket basket = new Basket(1L);
            basketRepo.save(basket);
        }

        Basket basket = basketRepo.getById(1L);

        List<Order> orders = orderRepo.findAll();

        model.addAttribute("cars", cars);
        model.addAttribute("filter", filter);
        model.addAttribute("basket", basket);
        model.addAttribute("orders", orders);

        return "main";
    }

    @PostMapping("new")
    public String add(@RequestParam String model,
                      @RequestParam String color,
                      @RequestParam int cost,
                      Model modl
    ) {
        Car car = new Car(model, color, cost);

        carRepo.save(car);
        Iterable<Car> cars = carRepo.findAll();

        modl.addAttribute("cars", cars);

        return "redirect:";
    }

    @PostMapping("add/{id}")
    public RedirectView toBasket(@PathVariable("id") Long id, Model model){
        Basket basket = basketRepo.getById(1L);

        Car car = carRepo.getById(id);

        car.setBasket(basket);
        carRepo.save(car);

        model.addAttribute("basket", basket);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080");

        return redirectView;
    }

    @PostMapping("drop/{id}")
    public RedirectView fromBasket(@PathVariable("id") Long id, Model model){
        Basket basket = basketRepo.getById(1L);

        Car car = carRepo.getById(id);

        car.setBasket(null);
        carRepo.save(car);

        model.addAttribute("basket", basket);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080");

        return redirectView;
    }

    @PostMapping("order")
    public String add(Model model) {
        Order order = new Order(basketRepo.getById(1L));

        order.getBasket().getCars().clear();

        order.setBasket(null);

        orderRepo.save(order);
        Iterable<Order> orders = orderRepo.findAll();

        model.addAttribute("orders", orders);

        return "redirect:";
    }
}
