package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.*;
import com.example.FoodDeliverProject.enums.ORDERSTATUS;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.*;
import com.example.FoodDeliverProject.serviceinterface.OrderedItemService;
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
    private OrderRepo orderRepo;


    @Override
    public List<OrderedItem> getOrders() {
        return orderedItemsRepo.findAll();
    }


    @Override
    public String  orderItem(List<OrderedItem> orderedItem,int userId,int restaurantId) throws UserdefineException {
        var usersObj = userRepo.findById(userId);
        Optional<Restaurant> restaurant = restaurantRepo.findById(restaurantId);
        Restaurant restaurant1 = restaurant.get();

        if(usersObj.isEmpty()){
            throw  new UserdefineException("User Not Found");
        }

        for(OrderedItem orderedItem1 : orderedItem){
            Optional<Menu>  menuObj = menuRepo.findById(orderedItem1.getItemId());
            Menu menu1 = menuObj.get();
            if(restaurantId!=menu1.getRestaurantId()){
                throw new UserdefineException(orderedItem1.getItemId()+" item is not present in this restaurant ");
            }
        }
        Order order = new Order();
        order.setUserId(userId);
        order.setRestaurantId(restaurantId);
        order.setTotalAmount(0);
        order.setStatus(ORDERSTATUS.payment_pending);
        orderRepo.save(order);

        double totalAmount=0;
        for(OrderedItem orderedItem1 : orderedItem){

            Optional<Menu>  menuObj = menuRepo.findById(orderedItem1.getItemId());
            Menu menu1 = menuObj.get();
//            if(menu1.getRestaurantId()!=restaurantId){
//                orderRepo.deleteById(order.getOrderId());
//                throw new UserdefineException(" item is not present in this restaurant ");
//            }

            OrderedItem orderedItem2 = new OrderedItem();
            orderedItem2.setOrderId(order.getOrderId());
            orderedItem2.setItemId(orderedItem1.getItemId());
            orderedItem2.setAmount(menu1.getPrice());
            orderedItem2.setQuantity(orderedItem1.getQuantity());
            totalAmount+= (menu1.getPrice()*orderedItem1.getQuantity());
            orderedItemsRepo.save(orderedItem2);

        }
        order.setTotalAmount(totalAmount);
        orderRepo.save(order);


//        if(menuObj==null){
//
//            throw new UserdefineException("Item not found");
//        }
//        Optional<Restaurant> restaurantObj = restaurantRepo.findById(menu1.getRestaurantId());
//        Restaurant restaurant1 = restaurantObj.get();
//
//        if((restaurant1.getRestaurantId())!=(restaurantId)){
//
//            throw new UserdefineException("Restaurant not found");
//        }
//
//           User user1 = usersObj.get();
//            OrderedItem orderedItem = new OrderedItem();
//
//
//            order.setUserId(user1.getUserId());
//            order.setRestaurantId(restaurant1.getRestaurantId());
//            order.setTotalAmount(menu1.getPrice() * quantity);
//            order.setStatus(ORDERSTATUS.valueOf("preparing"));
//            orderRepo.save(order);
//
//            orderedItem.setAmount(menu1.getPrice());
//            orderedItem.setOrderId(order.getOrderId());
//            orderedItem.setItemId(menu1.getItemId());
//            orderedItem.setQuantity(quantity);
//            orderedItemsRepo.save(orderedItem);


        return "order placed";
    }
}
