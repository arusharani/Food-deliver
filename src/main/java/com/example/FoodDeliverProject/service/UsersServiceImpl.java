package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Users;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsersServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
     @Override
    public List<Users> allUsers() {
        return userRepo.findAll();
    }

    @Override
    public Users addUser(Users users) throws UserdefineException{

        Users user1 = new Users();
        Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
        Matcher matcher = pattern.matcher(users.getPhoneNumber());
        if(matcher.matches()){
            user1.setPhoneNumber(user1.getPhoneNumber());
        }
        else {
            throw new UserdefineException("please enter a valid mobile no.");
        }
        user1.setUsername(users.getUsername());
        user1.setUserAddress(users.getUserAddress());

        return userRepo.save(user1);

    }
     @Override
    public void removeUser(int user_id) throws UserdefineException{
        Optional<Users> user=userRepo.findById(user_id);
        if(user.isEmpty())
            throw new UserdefineException("Invalid user id");
        userRepo.deleteById(user_id);
    }

    @Override
    public Users updateAddress(int user_id,String address) throws UserdefineException{
        Optional<Users> users = userRepo.findById(user_id);
        if(users.isEmpty())
            throw new UserdefineException("Invalid user id");
        Users users1= users.get();
        users1.setUserAddress(address);
        userRepo.save(users1);
        return users1;
    }

}
