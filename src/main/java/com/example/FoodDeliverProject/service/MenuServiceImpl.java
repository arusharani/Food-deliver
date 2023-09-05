package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Menu;
import com.example.FoodDeliverProject.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepo menuRepo;


    @Override
    public List<Menu> allMenu() {
        return menuRepo.findAll();
    }
}
