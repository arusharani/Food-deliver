package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface
UserRepo extends JpaRepository<User,Integer> {


    User findByUsername(String username);
}
