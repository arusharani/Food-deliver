package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.*;
import com.example.FoodDeliverProject.repo.*;
import com.example.FoodDeliverProject.serviceinterface.OrderedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedItemServiceImpl implements OrderedItemService {

    @Autowired
    private OrderedItemsRepo orderedItemsRepo;



    @Override
    public List<OrderedItem> getOrders() {
        return orderedItemsRepo.findAll();
    }


}
