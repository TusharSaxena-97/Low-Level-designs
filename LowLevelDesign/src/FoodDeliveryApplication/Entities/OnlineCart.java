package FoodDeliveryApplication.Entities;
import FoodDeliveryApplication.Models.*;

import java.util.*;


public class OnlineCart extends Cart{

    @Override
    public boolean clearCart() {
        menuItemList.clear();
        return true;
    }

    @Override
    public void addToCart(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }

    @Override
    public List<MenuItem> getCartItems() {
        return menuItemList;
    }
}
