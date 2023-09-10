package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Restaurant;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantServiceImpl restaurantServiceImpl;

    @GetMapping("/getRestaurant")
    public List<Restaurant> getRestaurant(){
        return restaurantServiceImpl.getRestaurant();
    }

    @PostMapping("/Restaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant)throws UserdefineException{
        return  restaurantServiceImpl.addRestaurant(restaurant);
    }

    @DeleteMapping("/Restaurant/{restaurant_id}")
    public String removeRestaurant(@PathVariable("restaurant_id")int restaurant_id) throws UserdefineException {
        restaurantServiceImpl.removeRestaurant(restaurant_id);
        return "deleted Restaurant"+restaurant_id;
    }

    @PutMapping("/Address/{restaurant_id}/{address}")
    public Restaurant updateRestaurantAddress(@PathVariable("restaurant_id")int restaurant_id, @PathVariable("address")String address){
        return restaurantServiceImpl.updateAddress(restaurant_id,address);
    }
}
