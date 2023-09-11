package com.example.FoodDeliverProject.serviceinterface;

import com.example.FoodDeliverProject.entities.Order;
import com.example.FoodDeliverProject.entities.OrderedItem;
import com.example.FoodDeliverProject.exceptions.UserDefineException;

import java.util.List;

public interface OrderService {

    public List<Order> getOrders();

    public List<Order> getOrdersByUser(int userId) throws UserDefineException;

    public String cancelOrder(int orderId) throws UserDefineException;

   // String updateAddress(int orderId,String Useraddress) throws UserdefineException;
   public String  orderItem(List<OrderedItem> orderedItem, int userId, int restaurantId) throws UserDefineException;

}
