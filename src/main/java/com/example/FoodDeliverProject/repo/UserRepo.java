package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
UserRepo extends JpaRepository<User,Integer> {

    User findByusername(String userName);
}
