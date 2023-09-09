package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.User;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/getUser")
    public List<User> getUsers(){
        return userServiceImpl.getUsers();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) throws UserdefineException{
        return  userServiceImpl.addUser(user);
    }

    @DeleteMapping("/User/{user_id}")
    public String removeUser(@PathVariable("user_id")int user_id) throws UserdefineException{
        userServiceImpl.removeUser(user_id);
        return "User deletedUser";
    }
    @PutMapping("/Address/{user_id}/{address}")
    public User updateAddress(@PathVariable("user_id")int user_id, @PathVariable("address")String address) throws UserdefineException {
        return userServiceImpl.updateAddress(user_id,address);
    }


}

