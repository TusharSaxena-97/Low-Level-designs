package FoodDeliveryApplication.Entities;
import FoodDeliveryApplication.Models.*;

import java.util.*;

public abstract class Cart implements ICart{
    protected List<MenuItem> menuItemList = new ArrayList<>();
}
