package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
UserRepo extends JpaRepository<Users,Integer> {

    Users findByusername(String userName);
}
