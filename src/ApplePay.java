public class ApplePay implements Payment {
    private static String cardNumber;
    private static String validThru;
    private static int cvv;

    static {
        cardNumber = "410011174743222";
        validThru = "11/23";
        cvv = 207;
    }

    @Override
    public void pay(int paymentAmount){
        System.out.println("The payment was successful through the Apple Pay system. Amount: $" + paymentAmount + ".");
    }

    public static void showCard(){
        System.out.println(cardNumber + " " + validThru + " " + cvv);
    }
}
