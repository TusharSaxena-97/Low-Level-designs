package BookMyShow.Services;

import BookMyShow.PaymentStartegy.IPaymentStrategy;

public abstract class PaymentService {
    protected IPaymentStrategy paymentStrategy;
    public abstract void makePayment();
}
