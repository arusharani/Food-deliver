package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.OrderedItems;
import com.example.FoodDeliverProject.exceptions.UserdefineException;

import java.util.List;

public interface OrderedItemService {

    public List<OrderedItems> allOrders();

    public String  orderItem(String restaurantName,String itemName, int quantity,String userName) throws UserdefineException;



}
