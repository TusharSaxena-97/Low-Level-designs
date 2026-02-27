package BookMyShow.PaymentStartegy;

public class CardPay implements IPaymentStrategy{

    @Override
    public void makePayment() {
        System.out.println("Making payment with Card");
    }

}
