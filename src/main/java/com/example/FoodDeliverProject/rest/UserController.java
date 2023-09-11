package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.User;
import com.example.FoodDeliverProject.exceptions.UserDefineException;
import com.example.FoodDeliverProject.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userServiceImpl.getUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) throws UserDefineException {
        return  userServiceImpl.addUser(user);
    }

    @DeleteMapping("/users/{user-id}")
    public String removeUser(@PathVariable("user-id")int userId) throws UserDefineException {
        userServiceImpl.removeUser(userId);
        return "deleted User "+userId;
    }

    @PutMapping("/user-address/{user-id}/address/{address}")
    public User updateAddress(@PathVariable("user-id")int userId, @PathVariable("address")String address) throws UserDefineException {
        return userServiceImpl.updateAddress(userId,address);
    }


}

