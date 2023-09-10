package com.example.FoodDeliverProject.entities;

import com.example.FoodDeliverProject.enums.ORDERSTATUS;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private int userId;
    private int restaurantId;
    private double totalAmount;
    @Enumerated(EnumType.STRING)
    private ORDERSTATUS status;
  @ManyToOne
  @JoinColumn(name="userId",referencedColumnName = "userId",insertable = false,updatable = false)
  @JsonIgnore
  private User user;

  @ManyToOne
  @JoinColumn(name = "restaurantId",referencedColumnName = "restaurantId",insertable = false,updatable = false)
  @JsonIgnore
  private Restaurant restaurant;

  @OneToOne(mappedBy = "order")
  @JsonIgnore
  private Payment payment;

  @OneToMany(mappedBy = "order")
  @JsonIgnore
  private List<OrderedItem> ordereditems;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ORDERSTATUS getStatus() {
        return status;
    }

    public void setStatus(ORDERSTATUS status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<OrderedItem> getOrdereditems() {
        return ordereditems;
    }

    public void setOrdereditems(List<OrderedItem> ordereditems) {
        this.ordereditems = ordereditems;
    }
}
