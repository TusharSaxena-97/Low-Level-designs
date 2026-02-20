package FoodDeliveryApplication.Strategies.PaymentStrategy;

public class UPI extends IPayment{

    public UPI( IPaymentStrategy paymentStrategy)
    {
        this.paymentStrategy = paymentStrategy;
    }
}
