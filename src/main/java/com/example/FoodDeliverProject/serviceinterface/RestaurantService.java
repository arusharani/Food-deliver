package com.example.FoodDeliverProject.serviceinterface;

import com.example.FoodDeliverProject.entities.Restaurant;
import com.example.FoodDeliverProject.exceptions.UserDefineException;

import java.util.List;

public interface RestaurantService {

    public List<Restaurant> getRestaurant();

    public Restaurant addRestaurant(Restaurant restaurant) throws UserDefineException;

    public void removeRestaurant(int restaurant_id) throws UserDefineException;

    public Restaurant updateAddress(int restaurant_id,String address) throws UserDefineException;
}
