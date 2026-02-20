package FoodDeliveryApplication.Models;

public class MenuItem {
    private static int nextCode = 1001;
    private String name;
    private int price;
    private int code;

    public MenuItem(String name, int price ) {
        this.name = name;
        this.price = price;
        this.code = this.nextCode++;
    }

    public MenuItem()
    {
        code = nextCode++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
