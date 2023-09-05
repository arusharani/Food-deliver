package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Menu;
import com.example.FoodDeliverProject.service.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuServiceImpl menuServiceImpl;

    @GetMapping("/allMenu")
    public List<Menu> allMenu() {

        return menuServiceImpl.allMenu();

    }

}
