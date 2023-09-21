package com.example.FoodDeliverProject.rest;

import com.example.FoodDeliverProject.entities.Payment;
import com.example.FoodDeliverProject.entities.User;
import com.example.FoodDeliverProject.exceptions.UserDefineException;
import com.example.FoodDeliverProject.repo.UserRepo;
import com.example.FoodDeliverProject.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentServiceImpl paymentServiceImpl;

    @Autowired
    private UserRepo userRepo;
    @GetMapping("/payments")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Payment> getPayment() {
        return paymentServiceImpl.getPayment();
    }

    @PostMapping("/pay")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Payment payIt(@RequestParam("order-id")int orderId,@RequestParam("payment-type")String paymentType) throws UserDefineException {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepo.findByUsername(username);
        return paymentServiceImpl.payIt(orderId,user.getUserId(),paymentType);
    }





}
