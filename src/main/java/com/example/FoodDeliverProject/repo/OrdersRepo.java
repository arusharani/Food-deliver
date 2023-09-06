package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.Orders;
import com.example.FoodDeliverProject.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders,Integer> {
    List<Orders> getOrdersByUsers_username(String username);

    Orders findByUserId(int userId);
//    @Query("select userId from Orders where orderId=:id")
//    int getuser(@Param("id")int id);

}
