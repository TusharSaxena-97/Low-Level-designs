package FoodDeliveryApplication.Factories;
import FoodDeliveryApplication.Entities.IOrder;
import FoodDeliveryApplication.Entities.OfflineOrder;
import FoodDeliveryApplication.Entities.OnlineOrder;
import FoodDeliveryApplication.Entities.Order;
import FoodDeliveryApplication.Models.*;

import java.util.*;

public class OrderFactory {

    public static Order createOrder(User user , Restaurant restaurant , List<MenuItem> menuItemList, String orderType)
    {
        if( orderType.equals("Online") )
            return new OnlineOrder(user , restaurant , menuItemList );
        else if( orderType.equals("Offline") )
            return new OfflineOrder(user , restaurant , menuItemList);

        System.out.println("Please Specify Order Type...... Online/Offline");
        return null;
    }
}
