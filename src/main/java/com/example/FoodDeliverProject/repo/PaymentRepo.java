package com.example.FoodDeliverProject.repo;

import com.example.FoodDeliverProject.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
    List<Payment> findByOrderId(int orderId);
}
