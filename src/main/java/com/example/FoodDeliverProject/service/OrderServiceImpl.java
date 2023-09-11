package com.example.FoodDeliverProject.service;


import com.example.FoodDeliverProject.entities.*;
import com.example.FoodDeliverProject.enums.OrderStatus;
import com.example.FoodDeliverProject.exceptions.UserDefineException;
import com.example.FoodDeliverProject.repo.*;
import com.example.FoodDeliverProject.serviceinterface.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderedItemsRepo orderedItemsRepo;
    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }
   @Override
    public List<Order> getOrdersByUser(int userId) throws UserDefineException {
        List<Order> order=orderRepo.findByUserId(userId);
        if(order.isEmpty()){
            throw new UserDefineException("No user order details");
        }
        return order;
    }

    @Override
    public String cancelOrder(int orderId) throws UserDefineException {
       Optional<Order> orders = orderRepo.findById(orderId);

       if(orders.isEmpty()){
           throw new UserDefineException("Invalid OrderId");
       }
       Order order1 = orders.get();
       order1.setStatus(OrderStatus.CANCELLED);
       orderRepo.save(order1);
        List<OrderedItem> orderedItems=orderedItemsRepo.findByOrderId(orderId);
       orderedItemsRepo.deleteAll(orderedItems);

       return "Order cancelled";
    }


    @Override
    public String  orderItem(List<OrderedItem> orderedItem,int userId,int restaurantId) throws UserDefineException {
        var usersObj = userRepo.findById(userId);
        Optional<Restaurant> restaurant = restaurantRepo.findById(restaurantId);
        Restaurant restaurant1 = restaurant.get();

        if(usersObj.isEmpty()){
            throw  new UserDefineException("User Not Found");
        }

        for(OrderedItem orderedItem1 : orderedItem){
            Optional<Menu>  menuObj = menuRepo.findById(orderedItem1.getItemId());
            Menu menu1 = menuObj.get();
            if(restaurantId!=menu1.getRestaurantId()){
                throw new UserDefineException(orderedItem1.getItemId()+" item is not present in this restaurant ");
            }
        }
        Order order = new Order();
        order.setUserId(userId);
        order.setRestaurantId(restaurantId);
        order.setTotalAmount(0);
        order.setStatus(OrderStatus.PAYMENT_PENDING);
        orderRepo.save(order);

        double totalAmount=0;
        for(OrderedItem orderedItem1 : orderedItem){

            Optional<Menu>  menuObj = menuRepo.findById(orderedItem1.getItemId());
            Menu menu1 = menuObj.get();

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
        return "order placed";
    }



}
