public class MiPay implements Payment {
    private static String cardNumber;
    private static String validThru;
    private static int cvv;

    static {
        cardNumber = "4048415020898850";
        validThru = "12/25";
        cvv = 669;
    }

    @Override
    public void pay(int paymentAmount){
        System.out.println("The payment was successful through the Mi Pay system. Amount: $" + paymentAmount + ".");
    }

    public static void showCard(){
        System.out.println(cardNumber + " " + validThru + " " + cvv);
    }
}
