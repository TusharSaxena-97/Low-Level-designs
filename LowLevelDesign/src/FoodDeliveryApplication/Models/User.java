package FoodDeliveryApplication.Models;
import FoodDeliveryApplication.Entities.ICart;

public class User {
    private static int nextUsedId = 1;
    private String name;
    private String userId;
    private String address;
    private ICart cart;

    public  User(String name, String address) {
        this.name = name;
        this.address = address;
        userId = String.valueOf(nextUsedId++);
    }

    public static int getNextUsedId() {
        return nextUsedId;
    }

    public static void setNextUsedId(int nextUsedId) {
        User.nextUsedId = nextUsedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    public ICart getCart() {
        return cart;
    }

    public void setCart(ICart cart) {
        this.cart = cart;
    }
}
