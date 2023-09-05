package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Users;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
     @Override
    public List<Users> allUsers() {
        return userRepo.findAll();
    }

    @Override
    public Users addUser(Users users) {
        Users user1 = new Users();
        user1.setUsername(users.getUsername());
        user1.setUserAddress(users.getUserAddress());
        user1.setPhoneNumber(users.getPhoneNumber());
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
