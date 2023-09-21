package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Restaurant;
import com.example.FoodDeliverProject.exceptions.UserDefineException;
import com.example.FoodDeliverProject.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant)throws UserDefineException {
        return  restaurantServiceImpl.addRestaurant(restaurant);
    }

    @DeleteMapping("/restaurants/{restaurant-id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String removeRestaurant(@PathVariable("restaurant-id")int restaurantId) throws UserDefineException {
        restaurantServiceImpl.removeRestaurant(restaurantId);
        return "deleted Restaurant"+restaurantId;
    }

    @PutMapping("/address/{restaurant-id}/address/{address}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Restaurant updateRestaurantAddress(@PathVariable("restaurant-id")int restaurantId, @PathVariable("address")String address) throws  UserDefineException{
        return restaurantServiceImpl.updateAddress(restaurantId,address);
    }
}
