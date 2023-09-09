package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Payment;
import com.example.FoodDeliverProject.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentServiceImpl paymentServiceImpl;
    @GetMapping("/getPayments")
    public List<Payment> getPayment() {
        return paymentServiceImpl.getPayment();
    }


}
