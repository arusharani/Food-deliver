package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Integer> {
   // List<Order> getOrdersByUsers_username(String username);

    List<Order> findByUserId(int userId);


}
