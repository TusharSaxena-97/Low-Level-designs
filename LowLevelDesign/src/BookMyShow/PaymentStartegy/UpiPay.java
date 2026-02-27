package BookMyShow.PaymentStartegy;

public class UpiPay implements IPaymentStrategy{

    @Override
    public void makePayment() {
        System.out.println("Making payment via UPI");
    }

}
