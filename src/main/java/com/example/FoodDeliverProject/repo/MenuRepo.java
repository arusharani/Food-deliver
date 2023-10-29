package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.Menu;
import com.example.FoodDeliverProject.serviceinterface.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository<Menu,Integer> {


    Menu findByItemName(String itemName);
}
