package BookMyShow.Services;

import BookMyShow.PaymentStartegy.UpiPay;

public class PaymentServiceImpl extends PaymentService{

    public PaymentServiceImpl(){
        paymentStrategy = new UpiPay();
    }

    @Override
    public void makePayment() {
        this.paymentStrategy.makePayment();
    }
}
