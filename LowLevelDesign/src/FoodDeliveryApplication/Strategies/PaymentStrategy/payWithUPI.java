package FoodDeliveryApplication.Strategies.PaymentStrategy;

public class payWithUPI implements IPaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Paying with UPI");
    }
}
