package FoodDeliveryApplication.Entities;

import FoodDeliveryApplication.Models.MenuItem;
import java.util.*;

public interface ICart {
    public boolean clearCart();
    public void addToCart(MenuItem menuItem);
    public List<MenuItem> getCartItems();
}
