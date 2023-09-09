package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.User;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.UserRepo;
import com.example.FoodDeliverProject.serviceinterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
     @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User addUser(User user) throws UserdefineException{

        User user1 = new User();
        Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
        Matcher matcher = pattern.matcher(user.getPhoneNumber());
        if(matcher.matches()){
            user1.setPhoneNumber(user.getPhoneNumber());
        }
        else {
            throw new UserdefineException("please enter a valid mobile no.");
        }
        user1.setUsername(user.getUsername());
        user1.setUserAddress(user.getUserAddress());
        user1.setCreatedAt(LocalDateTime.now());
        user1.setUpdatedAt(LocalDateTime.now());
        return userRepo.save(user1);

    }
     @Override
    public void removeUser(int user_id) throws UserdefineException{
        Optional<User> user=userRepo.findById(user_id);
        if(user.isEmpty())
            throw new UserdefineException("Invalid user id");
        userRepo.deleteById(user_id);
    }

    @Override
    public User updateAddress(int user_id, String address) throws UserdefineException{
        Optional<User> users = userRepo.findById(user_id);
        if(users.isEmpty())
            throw new UserdefineException("Invalid user id");
        User user1 = users.get();
        user1.setUserAddress(address);
        user1.setUpdatedAt(LocalDateTime.now());
        userRepo.save(user1);
        return user1;
    }

}
