public class SamsungPay implements Payment {
    private static String cardNumber;
    private static String validThru;
    private static int cvv;

    static {
        cardNumber = "4890494751804113";
        validThru = "08/24";
        cvv = 105;
    }

    @Override
    public void pay(int paymentAmount){
        System.out.println("The payment was successful through the Samsung Pay system. Amount: $" + paymentAmount + ".");
    }

    public static void showCard(){
        System.out.println(cardNumber + " " + validThru + " " + cvv);
    }
}
