package FoodDeliveryApplication.Models;
import java.util.*;

public class Restaurant {
    private static int nextId = 0;
    private int id;
    private String Name;
    private String Address;
    private List<MenuItem> menuItemList = new ArrayList<>();

    public Restaurant(String name, String address, List<MenuItem> menuItemList) {
        Name = name;
        Address = address;
        this.menuItemList = menuItemList;
        this.id = ++nextId;
    }

    public Restaurant( )
    {
        this.id = ++nextId;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
}
