package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Menu;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.MenuRepo;
import com.example.FoodDeliverProject.serviceinterface.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepo menuRepo;


    @Override
    public List<Menu> getMenu() {
        return menuRepo.findAll();
    }

    @Override
    public Menu addItem(Menu menu) {
        Menu menu1 = new Menu();
        menu1.setItemName(menu.getItemName());
        menu1.setRestaurantId(menu.getRestaurantId());
        menu1.setPrice(menu.getPrice());
        return   menuRepo.save(menu1);
    }





}
