package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Orders;
import com.example.FoodDeliverProject.exceptions.UserdefineException;

import java.util.List;

public interface OrderService {

    public List<Orders> allOrders();

    public List<Orders> getOrdersByUser(String username);

    public String cancelOrder(int orderId) throws UserdefineException;

    String updateAddress(int orderId,String Useraddress) throws UserdefineException;
}
