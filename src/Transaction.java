import java.util.Date;

public final class Transaction {
    private final String payer;
    private final Date date = new Date();
    private final String bank;
    private final int amount;
    private final int operationID;

    private static String cardNumber;
    private static String validThru;
    private static int cvv;

    static {
        cardNumber = "410011174743222";
        validThru = "11/23";
        cvv = 207;
    }

    public Transaction(String payer, String bank, int amount) {
        this.payer = payer;
        this.bank = bank;
        this.amount = amount;
        operationID = (int) (Math.random() * (2147483647-1000000000)+1000000000);
    }

    public String getPayer() {
        return payer;
    }

    public Date getDate() {
        return date;
    }

    public String getBank() {
        return bank;
    }

    public int getAmount() {
        return amount;
    }

    public int getOperationID() {
        return operationID;
    }

    public static void showCardDetails(){
        System.out.println(cardNumber + " " + validThru + " " + cvv);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "payer='" + payer + '\'' +
                ", date=" + date +
                ", bank='" + bank + '\'' +
                ", amount=$" + amount +
                ", operationID=" + operationID +
                '}';
    }
}
