package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Users;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersServiceImpl usersServiceImpl;

    @GetMapping("/allUser")
    public List<Users> allUsers(){
        return usersServiceImpl.allUsers();
    }

    @PostMapping("/adduser")
    public Users addUser(@RequestBody Users users){
        return  usersServiceImpl.addUser(users);
    }

    @DeleteMapping("/removeUser/{user_id}")
    public String removeUser(@PathVariable("user_id")int user_id) throws UserdefineException{
        usersServiceImpl.removeUser(user_id);
        return "User deletedUser";
    }
    @PutMapping("/updateAddress/{user_id}/{address}")
    public Users updateAddress(@PathVariable("user_id")int user_id, @PathVariable("address")String address) throws UserdefineException {
        return usersServiceImpl.updateAddress(user_id,address);
    }

}

