package com.example.FoodDeliverProject.serviceinterface;

import com.example.FoodDeliverProject.entities.User;
import com.example.FoodDeliverProject.exceptions.UserDefineException;

import java.util.List;

public interface UserService {

    public List<User> getUsers();
    public void removeUser(int user_id) throws UserDefineException;


    public User addUser(User user) throws UserDefineException;

     User updateAddress(int user_id, String address) throws UserDefineException;

    User updatePassword(int userId, String password);

    // public String authenticateAndGetToken(@RequestBody AuthRequest authRequest);
}
