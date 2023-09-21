package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.User;

import com.example.FoodDeliverProject.exceptions.UserDefineException;
import com.example.FoodDeliverProject.repo.UserRepo;
import com.example.FoodDeliverProject.serviceinterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtService jwtService;
     @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User addUser(User user) throws UserDefineException {

        User user1 = new User();
        Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
        Matcher matcher = pattern.matcher(user.getPhoneNumber());
        if(matcher.matches()){
            user1.setPhoneNumber(user.getPhoneNumber());
        }
        else {
            throw new UserDefineException("please enter a valid mobile no.");
        }
        user1.setUsername(user.getUsername());
        user1.setUserAddress(user.getUserAddress());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setCreatedAt(LocalDateTime.now());
        user1.setUpdatedAt(LocalDateTime.now());
        if(user.getRoles().equals("ROLE_USER")||user.getRoles().equals("ROLE_ADMIN")){
            user1.setRoles(user.getRoles());
        }
        else{
            throw new UserDefineException("Please enter a valid role");
        }

        return userRepo.save(user1);

    }
     @Override
    public void removeUser(int user_id) throws UserDefineException {
        Optional<User> user=userRepo.findById(user_id);
        if(user.isEmpty())
            throw new UserDefineException("Invalid user id");
        userRepo.deleteById(user_id);
    }

    @Override
    public User updateAddress(int userId, String address) throws UserDefineException {
        Optional<User> users = userRepo.findById(userId);
        if(users.isEmpty())
            throw new UserDefineException("Invalid user id");
        User user1 = users.get();
        user1.setUserAddress(address);
        user1.setUpdatedAt(LocalDateTime.now());
        userRepo.save(user1);
        return user1;
    }

    @Override
    public User updatePassword(int userId, String password) {
         Optional<User> user = userRepo.findById(userId);
         User user1 = user.get();
         user1.setPassword(passwordEncoder.encode(password));
         user1.setUpdatedAt(LocalDateTime.now());
          return userRepo.save(user1);

    }

//    @Override
//    public String authenticateAndGetToken(AuthRequest authRequest) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
//        if(authentication.isAuthenticated()){
//            return jwtService.generateToken(authRequest.getUsername());
//        }
//        else {
//            throw new UsernameNotFoundException("user not found");
//        }
//
//    }

}
