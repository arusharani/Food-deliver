package com.example.FoodDeliverProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private int userId;
    private int restaurantId;
    private double totalAmount;
    private String status;
  @ManyToOne
  @JoinColumn(name="userId",referencedColumnName = "userId",insertable = false,updatable = false)
  @JsonIgnore
  private Users users;

  @ManyToOne
  @JoinColumn(name = "restaurantId",referencedColumnName = "restaurantId",insertable = false,updatable = false)
  @JsonIgnore
  private Restaurant restaurant;

  @OneToOne(mappedBy = "orders")
  @JsonIgnore
  private Payment payment;

  @OneToMany(mappedBy = "orders")
  @JsonIgnore
  private List<OrderedItems> ordereditems;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

    public List<OrderedItems> getOrdereditems() {
        return ordereditems;
    }

    public void setOrdereditems(List<OrderedItems> ordereditems) {
        this.ordereditems = ordereditems;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
