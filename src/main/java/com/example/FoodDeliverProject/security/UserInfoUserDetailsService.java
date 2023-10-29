package com.example.FoodDeliverProject.security;

import com.example.FoodDeliverProject.entities.User;
import com.example.FoodDeliverProject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = Optional.ofNullable(userRepo.findByUsername(username));

        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }

}
