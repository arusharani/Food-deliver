package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedItemsRepo extends JpaRepository<OrderedItem,Integer> {

    List<OrderedItem> findByOrderId(int id);
}
