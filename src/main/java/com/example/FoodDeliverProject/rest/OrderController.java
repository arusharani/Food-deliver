package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Order;
import com.example.FoodDeliverProject.entities.OrderedItem;
import com.example.FoodDeliverProject.exceptions.UserDefineException;
import com.example.FoodDeliverProject.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;
    @GetMapping("/orders")
    public List<Order> getOrders() {

        return orderServiceImpl.getOrders();

    }
    @GetMapping("/orders/{user-id}")
    public List<Order> getOrders(@PathVariable("user-id") int userId) throws UserDefineException {

        return orderServiceImpl.getOrdersByUser(userId);
    }

    @DeleteMapping("/orders/{order-Id}")
    public String cancelOrder(int orderId) throws UserDefineException {
        return orderServiceImpl.cancelOrder(orderId);
    }

    @PostMapping("/ordered-Items")
    public  String orderItem(@RequestBody List<OrderedItem> orderedItem, @RequestParam("user-Id")int userId, @RequestParam("restaurant-Id")int restaurantId) throws UserDefineException {
        return   orderServiceImpl.orderItem(orderedItem,userId,restaurantId);

    }

}
