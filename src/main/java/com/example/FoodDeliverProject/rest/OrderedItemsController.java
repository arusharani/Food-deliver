package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.OrderedItem;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.service.OrderedItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderedItemsController {

    @Autowired
    private OrderedItemServiceImpl orderedItemServiceImpl;

    @GetMapping("/getOrderedItems")
    public List<OrderedItem> getOrdered() {

        return orderedItemServiceImpl.getOrders();

    }

    @PostMapping("/orderItem")
    public  String orderItem(@RequestBody List<OrderedItem> orderedItem, @RequestParam("userId")int userId) throws UserdefineException {
        return   orderedItemServiceImpl.orderItem(orderedItem,userId);

    }
}
