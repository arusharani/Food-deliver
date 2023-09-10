package com.example.FoodDeliverProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="ordereditems")
public class OrderedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderedItemsId;
    private int orderId;
    private int itemId;
    private double amount;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "orderId",referencedColumnName = "orderId",insertable = false,updatable = false)
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "itemId",referencedColumnName = "itemId",insertable = false,updatable = false)
    @JsonIgnore
    private Menu menu;

    public int getOrderedItemsId() {
        return orderedItemsId;
    }

    public void setOrderedItemsId(int orderedItemsId) {
        this.orderedItemsId = orderedItemsId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
