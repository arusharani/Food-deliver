package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.OrderedItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedItemsRepo extends JpaRepository<OrderedItems,Integer> {
}
