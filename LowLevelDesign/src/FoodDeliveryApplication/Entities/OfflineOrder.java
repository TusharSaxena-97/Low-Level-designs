package FoodDeliveryApplication.Entities;
import FoodDeliveryApplication.Models.*;

import java.util.*;

public class OfflineOrder extends Order{

    public OfflineOrder(User user , Restaurant restaurant , List<MenuItem> menuItemList)
    {
        this.user = user;
        this.restaurant = restaurant;
        this.menuItemList = menuItemList;
    }
}
