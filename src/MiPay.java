public class MiPay implements Payment {
    @Override
    public void pay(Transaction transaction){
        System.out.println("The payment was successful through the Mi Pay system. " + transaction.toString());
    }
}
