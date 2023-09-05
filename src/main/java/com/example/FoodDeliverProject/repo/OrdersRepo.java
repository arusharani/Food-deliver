package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders,Integer> {
    List<Orders> getOrdersByUsers_username(String username);

    Orders findByUserId(int userId);
}
