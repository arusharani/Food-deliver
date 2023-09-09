package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Payment;
import com.example.FoodDeliverProject.repo.OrderRepo;
import com.example.FoodDeliverProject.repo.PaymentRepo;
import com.example.FoodDeliverProject.repo.UserRepo;
import com.example.FoodDeliverProject.serviceinterface.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderRepo orderRepo;


    @Override
    public List<Payment> getPayment() {
        return paymentRepo.findAll();
    }



}
