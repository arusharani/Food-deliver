package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Orders;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.service.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/cancelOrder/{orderId}")
    public String cancelOrder(int orderId) throws UserdefineException {
        return ordersServiceImpl.cancelOrder(orderId);
    }
@PutMapping("/update_order_address/{orderid}/{address}")
    public String updateaddress(@PathVariable("orderid")int id,@PathVariable("address")String address) throws UserdefineException {

return ordersServiceImpl.updateAddress(id,address);
}
}
