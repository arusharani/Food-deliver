package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Restaurant;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.RestaurantRepo;
import com.example.FoodDeliverProject.serviceinterface.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public List<Restaurant> getRestaurant(){
        return restaurantRepo.findAll();
    }

    @Override

    public Restaurant addRestaurant(Restaurant restaurant)throws UserdefineException {

        Restaurant restaurant1 = new Restaurant();
        Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
        Matcher matcher= pattern.matcher(restaurant.getContactNumber());
        if(matcher.matches()){
            restaurant1.setContactNumber(restaurant1.getContactNumber());
        }
        else {
            throw new UserdefineException("please enter a valid mobile no.");
        }

        restaurant1.setRestaurantName(restaurant.getRestaurantName());
        restaurant1.setRestaurantAddress(restaurant.getRestaurantAddress());
        restaurant1.setContactNumber(restaurant.getContactNumber());
        restaurant1.setCreatedAt(LocalDateTime.now());
        restaurant1.setUpdatedAt(LocalDateTime.now());
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
        restaurant1.setUpdatedAt(LocalDateTime.now());
        restaurantRepo.save(restaurant1);
        return restaurant1;
    }


}
