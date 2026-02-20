package FoodDeliveryApplication;

import FoodDeliveryApplication.Entities.ICart;
import FoodDeliveryApplication.Entities.IOrder;
import FoodDeliveryApplication.Entities.OnlineCart;
import FoodDeliveryApplication.Entities.Order;
import FoodDeliveryApplication.Mangers.OrderManager;
import FoodDeliveryApplication.Mangers.RestaurantManager;
import FoodDeliveryApplication.Models.MenuItem;
import FoodDeliveryApplication.Models.Restaurant;
import FoodDeliveryApplication.Models.User;
import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Client {

    public static void main( String args[] ) throws Exception
    {
        Tomato app = new Tomato(dineType.Online);
        app.registerUser("Tushar","Goa");
        app.displayItemsbyLocality("Goa");

        Thread.currentThread().sleep(2000);

        app.addToCart( 1, 1 );
        app.placeOrder();

    }
}

class Tomato{

    private RestaurantManager restaurantManager;
    private User user;
    private ICart cart;
    private Order order;

    private List<Restaurant> displayMenu;
    private Restaurant restaurantSelected;

    Tomato(dineType d)
    {
        MenuItem me1 = new MenuItem("Rajma Chawal" , 100);
        MenuItem me2 = new MenuItem("Dal Chawal" , 800);
        MenuItem me3 = new MenuItem("Chhole Chawal" , 80);
        MenuItem me4 = new MenuItem("Pulaw Chawal" , 90);

        List<MenuItem> menu = new ArrayList<>();
        menu.add( me1 );
        menu.add( me2 );
        menu.add( me3 );
        menu.add( me4 );

        restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(new Restaurant("BeachSide Cafe","Goa",menu) );
        restaurantManager.addRestaurant( new Restaurant("RoadSide Cafe","Patna",menu));

        cart = new OnlineCart();
    }

    public void registerUser(String Name , String Address )
    {
        this.user = new User(Name , Address );
        System.out.println("User Registered");
    }

    public void displayItemsbyLocality(String Address )
    {
        for( Restaurant res : restaurantManager.searchByAddress("Goa") )
        {
            System.out.println( res.getName() );
            System.out.println( res.getMenuItemList() );
        }
        displayMenu = restaurantManager.searchByAddress("Goa");
    }

    public void addToCart(int i, int j)
    {
        restaurantSelected = displayMenu.get(i-1);
        cart.addToCart( restaurantSelected.getMenuItemList().get(j) );
    }

    public boolean placeOrder()
    {
        order = OrderManager.getInstance().CreateOrder( user , restaurantSelected , cart.getCartItems() );
        System.out.println("Order Placed for "+ order.getUser().getName()+" at Address "+order.getUser().getAddress() );
        return true;
    }

    private void payOrder()
    {

    }
}

enum dineType{
    DineIn,
    Online
}