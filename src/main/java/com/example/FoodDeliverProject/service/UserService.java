package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Users;
import com.example.FoodDeliverProject.exceptions.UserdefineException;

import java.util.List;

public interface UserService {

    public List<Users> allUsers();
    public void removeUser(int user_id) throws UserdefineException;


    public Users addUser(Users users);

    public Users updateAddress(int user_id,String address) throws UserdefineException;
}
