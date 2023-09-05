package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.OrderedItems;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.service.OrderedItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderedItemsController {

    @Autowired
    private OrderedItemServiceImpl orderedItemServiceImpl;

    @GetMapping("/allOrderedItems")
    public List<OrderedItems> allOrdered() {

        return orderedItemServiceImpl.allOrders();

    }

    @PostMapping("/orderAnItem")
    public  String orderAnItem(@RequestParam("restaurantName")String restaurantName,@RequestParam("itemName") String itemName,@RequestParam("quantity")int quantity,@RequestParam("userName")String userName) throws UserdefineException {
        return   orderedItemServiceImpl.orderItem(restaurantName,itemName,quantity,userName);

    }
}
