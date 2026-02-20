package FoodDeliveryApplication.Strategies.PaymentStrategy;

public class payWithNetbanking implements IPaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Paying with Net Banking");
    }
}
