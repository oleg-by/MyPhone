public class ApplePay implements Payment {
    @Override
    public void pay(Transaction transaction){
        System.out.println("The payment was successful through the Apple Pay system. " + transaction.toString());
    }
}
