package FoodDeliveryApplication.Strategies.PaymentStrategy;

public class CreditCard extends IPayment{

        CreditCard(IPaymentStrategy paymentStrategy)
        {
            this.paymentStrategy = paymentStrategy;
        }
}
