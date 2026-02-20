package FoodDeliveryApplication.Entities;

import FoodDeliveryApplication.Models.*;
import FoodDeliveryApplication.Strategies.PaymentStrategy.IPayment;
import FoodDeliveryApplication.Strategies.PaymentStrategy.IPaymentStrategy;

import java.sql.Array;
import java.util.*;

public abstract class Order implements IOrder {
    protected List<MenuItem> menuItemList = new ArrayList<>();
    protected Restaurant restaurant;
    protected User user;
    protected String type;
    protected OrderStatus orderStatus;
    protected IPayment payment;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public IPayment getPaymentStrategy() {
        return payment;
    }

    public void setPaymentStrategy(IPayment payment ) {
        this.payment = payment;
    }
}

enum OrderStatus
{
    Open,
    InProgress,
    Closed
}

