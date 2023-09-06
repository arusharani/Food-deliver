package com.example.FoodDeliverProject.service;


import com.example.FoodDeliverProject.entities.OrderedItems;
import com.example.FoodDeliverProject.entities.Orders;
import com.example.FoodDeliverProject.entities.Users;
import com.example.FoodDeliverProject.exceptions.UserdefineException;
import com.example.FoodDeliverProject.repo.OrderedItemsRepo;
import com.example.FoodDeliverProject.repo.OrdersRepo;
import com.example.FoodDeliverProject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrderService {
    @Autowired
    private OrdersRepo ordersRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderedItemsRepo orderedItemsRepo;

    @Override
    public List<Orders> allOrders() {
        return ordersRepo.findAll();
    }
    @Override
    public List<Orders> getOrdersByUser(String username){
        return  ordersRepo.getOrdersByUsers_username(username);
    }

    @Override
    public String cancelOrder(int orderId) throws UserdefineException{
       Optional<Orders> orders = ordersRepo.findById(orderId);
       //List<OrderedItems> orderedItems=orderedItemsRepo.findByOrderId(orderId);
       if(orders.isEmpty()){
           throw new UserdefineException("Invalid OrderId");
       }
       Orders orders1 = orders.get();
       orders1.setStatus("cancelled");
       ordersRepo.save(orders1);
        List<OrderedItems> orderedItems=orderedItemsRepo.findByOrderId(orderId);
       orderedItemsRepo.deleteAll(orderedItems);


       return "Order cancelled";
    }

    @Override
    public String updateAddress(int orderid, String Useraddress) throws UserdefineException {

        Optional<Orders>orders=ordersRepo.findById(orderid);
        if(orders.isEmpty())
            throw new UserdefineException("orderid is not found");
        Orders orders1=orders.get();
        Optional<Users>users22=userRepo.findById(orders1.getUserId());

       Users users1=users22.get();
       users1.setUserAddress(Useraddress);
       userRepo.save(users1);
       users1.setUserAddress(Useraddress);

         return  "address is updated";


    }

}
