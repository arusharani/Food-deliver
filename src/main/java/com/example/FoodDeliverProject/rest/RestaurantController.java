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

    @GetMapping("/allRestaurant")
    public List<Restaurant> allRestaurant(){
        return restaurantServiceImpl.allRestaurant();
    }

    @PostMapping("/addRestaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant)throws UserdefineException{
        return  restaurantServiceImpl.addRestaurant(restaurant);
    }

    @DeleteMapping("/removeRestaurant/{restaurant_id}")
    public String removeRestaurant(@PathVariable("restaurant_id")int restaurant_id) throws UserdefineException {
        restaurantServiceImpl.removeRestaurant(restaurant_id);
        return "Restaurant deletedRestaurant";
    }

    @PutMapping("/updateAddress/{restaurant_id}/{address}")
    public Restaurant updateAddress(@PathVariable("restaurant_id")int restaurant_id, @PathVariable("address")String address){
        return restaurantServiceImpl.updateAddress(restaurant_id,address);
    }
}
