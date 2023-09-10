package com.example.FoodDeliverProject.serviceinterface;

import com.example.FoodDeliverProject.entities.User;
import com.example.FoodDeliverProject.exceptions.UserdefineException;

import java.util.List;

public interface UserService {

    public List<User> getUsers();
    public void removeUser(int user_id) throws UserdefineException;


    public User addUser(User user) throws UserdefineException;

     User updateAddress(int user_id, String address) throws UserdefineException;
}
