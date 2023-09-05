package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Restaurant;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public List<Restaurant> allRestaurant(){
        return restaurantRepo.findAll();
    }

    @Override

    public Restaurant addRestaurant(Restaurant restaurant) {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantName(restaurant.getRestaurantName());
        restaurant1.setRestaurantAddress(restaurant.getRestaurantAddress());
        restaurant1.setContactNumber(restaurant.getContactNumber());
        return restaurantRepo.save(restaurant1);

    }

    @Override
    public void removeRestaurant(int restaurant_id) throws UserdefineException {
        Optional<Restaurant> restaurant = restaurantRepo.findById(restaurant_id);
        if (restaurant.isEmpty())
            throw new UserdefineException("Invalid restaurant id");
        restaurantRepo.deleteById(restaurant_id);
    }

    @Override
    public Restaurant updateAddress(int restaurant_id,String address) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(restaurant_id);

        Restaurant restaurant1 = restaurant.get();
        restaurant1.setRestaurantAddress(address);
        restaurantRepo.save(restaurant1);
        return restaurant1;
    }


}
