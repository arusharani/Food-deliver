package com.example.FoodDeliverProject.serviceinterface;

import com.example.FoodDeliverProject.entities.OrderedItem;
import com.example.FoodDeliverProject.exceptions.UserdefineException;

import java.util.List;

public interface OrderedItemService {

    public List<OrderedItem> getOrders();

    public String  orderItem(List<OrderedItem> orderedItem,int userId,int restaurantId) throws UserdefineException;



}
