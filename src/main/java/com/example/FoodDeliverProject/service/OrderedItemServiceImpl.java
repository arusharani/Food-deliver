package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.*;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderedItemServiceImpl implements OrderedItemService {

    @Autowired
    private OrderedItemsRepo orderedItemsRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrdersRepo ordersRepo;


    @Override
    public List<OrderedItems> allOrders() {
        return orderedItemsRepo.findAll();
    }


    @Override
    public String  orderItem(String restaurantName,String itemName, int quantity,String userName) throws UserdefineException {
        Menu menuObj = menuRepo.findByItemName(itemName);

        if(menuObj==null){

            throw new UserdefineException("Item not found");
        }
        Optional<Restaurant> restaurantObj = restaurantRepo.findById(menuObj.getRestaurantId());
        Restaurant restaurant1 = restaurantObj.get();

        if(!(restaurant1.getRestaurantName()).equals(restaurantName)){

            throw new UserdefineException("Restaurant not found");
        }
        var usersObj = userRepo.findByusername(userName);

        if(usersObj==null){
            throw  new UserdefineException("User Not Found");
        }

            OrderedItems orderedItems = new OrderedItems();

            Orders orders = new Orders();
            orders.setUserId(usersObj.getUserId());
            orders.setRestaurantId(restaurant1.getRestaurantId());
            orders.setTotalAmount(menuObj.getPrice() * quantity);
            orders.setStatus("preparing");
            ordersRepo.save(orders);

            orderedItems.setAmount(menuObj.getPrice());
            orderedItems.setOrderId(orders.getOrderId());
            orderedItems.setItemId(menuObj.getItemId());
            orderedItems.setQuantity(quantity);
            orderedItemsRepo.save(orderedItems);


        return "order placed";
    }
}
