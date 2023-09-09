package com.example.FoodDeliverProject.serviceinterface;

import com.example.FoodDeliverProject.entities.Order;
import com.example.FoodDeliverProject.exceptions.UserdefineException;

import java.util.List;

public interface OrderService {

    public List<Order> getOrders();

    public List<Order> getOrdersByUser(int userId) throws UserdefineException;

    public String cancelOrder(int orderId) throws UserdefineException;

    String updateAddress(int orderId,String Useraddress) throws UserdefineException;
}
