package FoodDeliveryApplication.Entities;
import FoodDeliveryApplication.Models.*;
import FoodDeliveryApplication.Strategies.PaymentStrategy.UPI;
import FoodDeliveryApplication.Strategies.PaymentStrategy.payWithUPI;

import java.util.List;

public class OnlineOrder extends Order{
    public OnlineOrder(User user, Restaurant restaurant, List<MenuItem> menuItemList) {
        this.user = user;
        this.restaurant = restaurant;
        this.menuItemList.add( new MenuItem());
        this.orderStatus = OrderStatus.Open;
        this.payment = new UPI(new payWithUPI() );
    }
}
