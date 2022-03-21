public class SamsungPay implements Payment {
    @Override
    public void pay(Transaction transaction){
        System.out.println("The payment was successful through the Samsung Pay system. " + transaction.toString());
    }
}
