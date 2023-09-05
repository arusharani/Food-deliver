package com.example.FoodDeliverProject.service;


import com.example.FoodDeliverProject.entities.Orders;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrderService {
    @Autowired
    private OrdersRepo ordersRepo;

    @Override
    public List<Orders> allOrders() {
        return ordersRepo.findAll();
    }
    @Override
    public List<Orders> getOrdersByUser(String username){
        return  ordersRepo.getOrdersByUsers_username(username);
    }

    @Override
    public String cancelOrder(int orderId) throws UserdefineException{
       Optional<Orders> orders = ordersRepo.findById(orderId);
       if(orders.isEmpty()){
           throw new UserdefineException("Invalid OrderId");
       }
       Orders orders1 = orders.get();
       orders1.setStatus("cancelled");
       ordersRepo.save(orders1);
       return "Order cancelled";
    }

}
