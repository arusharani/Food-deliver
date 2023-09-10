package com.example.FoodDeliverProject.serviceinterface;

import com.example.FoodDeliverProject.entities.Restaurant;
import com.example.FoodDeliverProject.exceptions.UserdefineException;

import java.util.List;

public interface RestaurantService {

    public List<Restaurant> getRestaurant();

    public Restaurant addRestaurant(Restaurant restaurant) throws UserdefineException;

    public void removeRestaurant(int restaurant_id) throws UserdefineException;

    public Restaurant updateAddress(int restaurant_id,String address);
}
