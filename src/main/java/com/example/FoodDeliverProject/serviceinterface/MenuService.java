package com.example.FoodDeliverProject.serviceinterface;

import com.example.FoodDeliverProject.entities.Menu;

import java.util.List;

public interface MenuService {


    public List<Menu> getMenu();

    Menu addItem(Menu menu);
}
