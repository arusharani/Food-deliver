package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Restaurant;
import com.example.FoodDeliverProject.exceptions.UserDefineException;
import com.example.FoodDeliverProject.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantServiceImpl restaurantServiceImpl;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantServiceImpl.getRestaurant();
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant)throws UserDefineException {
        return  restaurantServiceImpl.addRestaurant(restaurant);
    }

    @DeleteMapping("/restaurants/{restaurant-id}")
    public String removeRestaurant(@PathVariable("restaurant-id")int restaurantId) throws UserDefineException {
        restaurantServiceImpl.removeRestaurant(restaurantId);
        return "deleted Restaurant"+restaurantId;
    }

    @PutMapping("/address/{restaurant-id}/address/{address}")
    public Restaurant updateRestaurantAddress(@PathVariable("restaurant-id")int restaurantId, @PathVariable("address")String address) throws  UserDefineException{
        return restaurantServiceImpl.updateAddress(restaurantId,address);
    }
}
