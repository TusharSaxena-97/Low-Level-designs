package FoodDeliveryApplication.Strategies.PaymentStrategy;

public class payWithCreditCard implements IPaymentStrategy {

    @Override
    public void pay() {
        System.out.println("Paying with CC");
    }
}
