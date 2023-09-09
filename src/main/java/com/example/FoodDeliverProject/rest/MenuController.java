package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Menu;
import com.example.FoodDeliverProject.service.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuServiceImpl menuServiceImpl;

    @GetMapping("/getMenu")
    public List<Menu> getMenu() {

        return menuServiceImpl.getMenu();

    }
    @PostMapping("/item")
    public Menu addItem(@RequestBody Menu menu) {
        return menuServiceImpl.addItem(menu);
    }

}
