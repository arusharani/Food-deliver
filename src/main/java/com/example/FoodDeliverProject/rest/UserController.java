package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.User;
import com.example.FoodDeliverProject.exceptions.UserDefineException;
import com.example.FoodDeliverProject.repo.UserRepo;
import com.example.FoodDeliverProject.security.AuthRequest;
import com.example.FoodDeliverProject.security.JwtService;
import com.example.FoodDeliverProject.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {


    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> getUsers(){
        return userServiceImpl.getUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) throws UserDefineException {
        return  userServiceImpl.addUser(user);
    }

    @DeleteMapping("/users/{user-id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String removeUser(@PathVariable("user-id")int userId) throws UserDefineException {
        userServiceImpl.removeUser(userId);
        return "deleted User"+userId;
    }

    @PutMapping("/user-address/{address}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public User updateAddress( @PathVariable("address")String address) throws UserDefineException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username);
        return userServiceImpl.updateAddress(user.getUserId(),address);
    }

    @PutMapping("/password")
    public User updatePassword(@RequestParam("password") String password){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username);
        return userServiceImpl.updatePassword(user.getUserId(),password);
    }


    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws Exception{
       Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
       if(authentication.isAuthenticated())
           return jwtService.generateToken(authRequest.getUsername());
       else
           throw new UsernameNotFoundException("Invalid username");
    }

}

