package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Restaurant;
import com.example.FoodDeliverProject.exceptions.UserdefineException;

import java.util.List;

public interface RestaurantService {

    public List<Restaurant> allRestaurant();

    public Restaurant addRestaurant(Restaurant restaurant);

    public void removeRestaurant(int restaurant_id) throws UserdefineException;

    public Restaurant updateAddress(int restaurant_id,String address);
}
