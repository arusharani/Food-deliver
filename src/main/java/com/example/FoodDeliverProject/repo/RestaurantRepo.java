package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {
    Restaurant findByRestaurantName(String restaurantName);
}
