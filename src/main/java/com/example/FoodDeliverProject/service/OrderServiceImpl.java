package com.example.FoodDeliverProject.service;


import com.example.FoodDeliverProject.entities.Menu;
import com.example.FoodDeliverProject.entities.Order;
import com.example.FoodDeliverProject.entities.OrderedItem;
import com.example.FoodDeliverProject.entities.User;
import com.example.FoodDeliverProject.enums.ORDERSTATUS;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.OrderedItemsRepo;
import com.example.FoodDeliverProject.repo.OrderRepo;
import com.example.FoodDeliverProject.repo.UserRepo;
import com.example.FoodDeliverProject.serviceinterface.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderedItemsRepo orderedItemsRepo;

    @Override
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }
   @Override
    public List<Order> getOrdersByUser(int userId) throws UserdefineException {
        List<Order> order=orderRepo.findByUserId(userId);
        if(order.isEmpty()){
            throw new UserdefineException("No user order details");
        }
        return order;
    }

    @Override
    public String cancelOrder(int orderId) throws UserdefineException{
       Optional<Order> orders = orderRepo.findById(orderId);

       if(orders.isEmpty()){
           throw new UserdefineException("Invalid OrderId");
       }
       Order order1 = orders.get();
       order1.setStatus(ORDERSTATUS.cancelled);
       orderRepo.save(order1);
        List<OrderedItem> orderedItems=orderedItemsRepo.findByOrderId(orderId);
       orderedItemsRepo.deleteAll(orderedItems);

       return "Order cancelled";
    }



}
