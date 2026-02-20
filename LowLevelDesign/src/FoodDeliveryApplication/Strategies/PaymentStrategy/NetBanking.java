package FoodDeliveryApplication.Strategies.PaymentStrategy;

public class NetBanking extends IPayment {

    NetBanking(IPaymentStrategy paymentStrategy )
    {
        this.paymentStrategy = paymentStrategy;
    }
}
