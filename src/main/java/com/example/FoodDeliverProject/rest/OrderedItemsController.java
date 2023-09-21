package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.OrderedItem;
import com.example.FoodDeliverProject.service.OrderedItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderedItemsController {

    @Autowired
    private OrderedItemServiceImpl orderedItemServiceImpl;

    @GetMapping("/ordered-items")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<OrderedItem> getOrdered() {

        return orderedItemServiceImpl.getOrders();

    }


}
