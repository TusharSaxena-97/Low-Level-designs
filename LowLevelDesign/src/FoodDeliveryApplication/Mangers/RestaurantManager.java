package FoodDeliveryApplication.Mangers;
import FoodDeliveryApplication.Models.*;

import java.util.*;
import java.util.stream.Collectors;

public class RestaurantManager {
    private static volatile RestaurantManager instance;
    List<Restaurant> restaurantList = new ArrayList<>();

    // Private Constructor
    private RestaurantManager(){    }

    public static RestaurantManager getInstance()
    {
         if( instance == null )
             synchronized ( RestaurantManager.class )
             {
                 if( instance == null )
                     instance = new RestaurantManager();
             }
     return instance;
    }

    public void addRestaurant(Restaurant restaurant )
    {
        instance.restaurantList.add( restaurant );
    }

    public void deleterestaurant( Restaurant restaurant)
    {
        instance.restaurantList = instance.restaurantList.stream().filter( o -> o.equals(restaurant) ).collect( Collectors.toList() );
    }

    public void updateRestaurant(Restaurant restaurant)
    {
        deleterestaurant(restaurant);
        addRestaurant(restaurant);
    }

    public List<Restaurant> searchByAddress(String address)
    {
        return restaurantList.stream().filter( o -> o.getAddress()!=address ).collect( Collectors.toList() );
    }

}
