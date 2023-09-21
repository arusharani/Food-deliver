package com.example.FoodDeliverProject.serviceinterface;

import com.example.FoodDeliverProject.entities.Payment;
import com.example.FoodDeliverProject.exceptions.UserDefineException;

import java.util.List;

public interface PaymentService {

    public List<Payment> getPayment();

    Payment payIt(int orderId, int userId,String paymentType) throws UserDefineException;


}
