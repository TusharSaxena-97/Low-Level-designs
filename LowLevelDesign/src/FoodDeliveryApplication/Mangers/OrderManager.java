package FoodDeliveryApplication.Mangers;
import FoodDeliveryApplication.Entities.IOrder;
import FoodDeliveryApplication.Entities.Order;
import FoodDeliveryApplication.Factories.OrderFactory;
import FoodDeliveryApplication.Models.*;
import FoodDeliveryApplication.Strategies.PaymentStrategy.IPaymentStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class OrderManager {
    private volatile static OrderManager instance;
    private IPaymentStrategy paymentStrategy;
    protected List<IOrder> orderList;

    private OrderManager()
    {

    }

    public static OrderManager getInstance()
    {
        if( instance == null )
        {
            synchronized ( OrderManager.class )
            {
                if( instance == null )
                    instance = new OrderManager();
            }
        }
        return instance;
    }

    public Order CreateOrder(User user, Restaurant restaurant , List<MenuItem> menuItemList)
    {
        return OrderFactory.createOrder( user , restaurant , menuItemList , "Online" );
    }

    public static void deleteOrder( IOrder order )
    {
        instance.orderList = instance.orderList.stream().filter( o -> o.equals(order) ).collect( Collectors.toList() );
    }
}
