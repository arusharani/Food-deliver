package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Orders;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.service.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    private OrdersServiceImpl ordersServiceImpl;
    @GetMapping("/allOrders")
    public List<Orders> allOrders() {

        return ordersServiceImpl.allOrders();

    }
    @GetMapping("/allOrders/{username}")
    public List<Orders> allOrders(@PathVariable("username") String username) {

        return ordersServiceImpl.getOrdersByUser(username);
    }

    @PostMapping("/cancelOrder/{orderId}")
    public String cancelOrder(int orderId) throws UserdefineException {
        return ordersServiceImpl.cancelOrder(orderId);
    }

}
