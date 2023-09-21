package com.example.FoodDeliverProject.service;

import com.example.FoodDeliverProject.entities.Order;
import com.example.FoodDeliverProject.entities.Payment;
import com.example.FoodDeliverProject.enums.OrderStatus;
import com.example.FoodDeliverProject.enums.PaymentStatus;
import com.example.FoodDeliverProject.exceptions.UserDefineException;
import com.example.FoodDeliverProject.repo.OrderRepo;
import com.example.FoodDeliverProject.repo.PaymentRepo;
import com.example.FoodDeliverProject.repo.UserRepo;
import com.example.FoodDeliverProject.serviceinterface.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Payment payIt(int orderId, int userId,String paymentType) throws UserDefineException {

        Optional<Order> order = orderRepo.findById(orderId);
        Order order1 = order.get();
        if(!(order1.getStatus().equals(OrderStatus.PAYMENT_PENDING))){
            throw  new UserDefineException("payment is already done");
        }

        if(order1.getUserId()!=userId){
            throw new UserDefineException("invalid user trying to make the payment");
        }

        Payment payment = new Payment();

        payment.setCreatedAt(LocalDateTime.now());
        payment.setOrderId(orderId);
        if(paymentType.equals("UPI")){
            payment.setPaymentType("UPI");
            payment.setStatus(PaymentStatus.SUCCESS);
        } else if (paymentType.equals("cash on delivery")) {
            payment.setPaymentType("cash on delivery");
            payment.setStatus(PaymentStatus.PENDING);
        } else if (paymentType.equals("online payment")) {
            payment.setPaymentType("online payment");
            payment.setStatus(PaymentStatus.SUCCESS);
        }
        else{
            throw new UserDefineException("enter a valid payment option");
        }

        payment.setPaymentAmount(order1.getTotalAmount());
        order1.setStatus(OrderStatus.ON_THE_WAY);
        orderRepo.save(order1);
        return paymentRepo.save(payment);
    }




}
