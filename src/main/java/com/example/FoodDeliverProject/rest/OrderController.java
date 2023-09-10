package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Order;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;
    @GetMapping("/getOrders")
    public List<Order> getOrders() {

        return orderServiceImpl.getOrders();

    }
    @GetMapping("/getOrders/{userid}")
    public List<Order> getOrders(@PathVariable("userid") int userId) throws UserdefineException {

        return orderServiceImpl.getOrdersByUser(userId);
    }

    @DeleteMapping("/cancelOrder/{orderId}")
    public String cancelOrder(int orderId) throws UserdefineException {
        return orderServiceImpl.cancelOrder(orderId);
    }
//    @PutMapping("/order_address/{orderid}/address/{address}")
//    public String updateaddress(@PathVariable("orderid")int id,@PathVariable("address")String address) throws UserdefineException {
//
//    return orderServiceImpl.updateAddress(id,address);
//    }
}
