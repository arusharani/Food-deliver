package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Order;
import com.example.FoodDeliverProject.entities.OrderedItem;
import com.example.FoodDeliverProject.entities.User;
import com.example.FoodDeliverProject.exceptions.UserDefineException;
import com.example.FoodDeliverProject.repo.UserRepo;
import com.example.FoodDeliverProject.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/all-orders")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Order> getOrders() {
        return orderServiceImpl.getOrders();

    }
    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('ROLE_USER')||hasAuthority('ROLE_ADMIN')")
    public List<Order> getUserOrders() throws UserDefineException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
          User user= userRepo.findByUsername(username);
        return orderServiceImpl.getOrdersByUser(user.getUserId());
    }

    @DeleteMapping("/orders/{order-Id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String cancelOrder(int orderId) throws UserDefineException {
        return orderServiceImpl.cancelOrder(orderId);
    }

    @PostMapping("/orders")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public  String orderItem(@RequestBody List<OrderedItem> orderedItem,  @RequestParam("restaurant-Id")int restaurantId) throws UserDefineException {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepo.findByUsername(username);
        return   orderServiceImpl.orderItem(orderedItem,user.getUserId(),restaurantId);

    }

}
