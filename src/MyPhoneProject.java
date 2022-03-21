public class MyPhoneProject {
    public static void main(String[] args) {
        CPU cpuApple = new CPU("Apple A15 Bionic", 3240);
        CPU cpuIpad = new CPU("Apple M1", 3200);
        CPU cpuQualcomm = new CPU("Qualcomm Snapdragon 8 Gen1", 3000);
        Battery batteryApple = new Battery(4325, "Li-ion");
        Battery batterySamsung = new Battery(5000, "Li-ion");
        Battery batteryIpad = new Battery(9720, "Li-ion");
        Battery batteryWatch = new Battery(1094, "Li-ion");
        Phone iphone = new Phone("phone", "Apple", "Iphone 13 PRO MAX", "160.8 x 78.1 x 7.7", "white", 240, batteryApple, 291112233, "iOS" ,cpuApple);
        Phone samsung = new Phone("phone", "Samsung", "Galaxy S22 Ultra", "163.3 x 77.9 x 8.9", "blue", 229, batterySamsung, 447775566, "Android", cpuQualcomm);
        Tablet ipad = new Tablet("tablet", "Apple", "iPad Pro","280.6 x 214.9 x 6.4", "silver", 684, batteryIpad, "iPadOS 15", cpuIpad, (float)12.9);
        SmartWatch watch = new SmartWatch("smart watch", "Apple", "Watch Series 7", "45 x 38 x 10.7", "grey", 39, batteryWatch, (float)1.9);
        Caller alex = new Caller("Alex", iphone.getPhoneNumber());
        Caller mary = new Caller("Mary", samsung.getPhoneNumber());
        Transaction[] transactions = new Transaction[4];
        transactions[0] = new Transaction("John Brown", "Bank of America", 1000);
        transactions[1] = new Transaction("Jack Russel", "The Bank of New York", 550);
        transactions[2] = new Transaction("Antony Green", "Bank of America", 300);
        transactions[3] = new Transaction("Mary Carry", "The Bank of New York", 250);

        iphone.makePayment(transactions[0]);
        Transaction.showCardDetails();
        samsung.makePayment(transactions[1]);
        Transaction.showCardDetails();
        ipad.makePayment(transactions[2]);
        Transaction.showCardDetails();
        watch.makePayment(transactions[3]);
        Transaction.showCardDetails();

        iphone.sendMessage("Hello Mary! How are you!", mary);
        System.out.println(iphone.getMessage(alex));

        Camera iphoneTest = new Phone("Apple", "Iphone 13", batteryApple, 2225548);
        iphoneTest.photograph();

    /*  System.out.println(iphone.toString() + " HashCode = " + iphone.hashCode());
        System.out.println(samsung.toString() + " HashCode = " + samsung.hashCode());
        System.out.println(ipad.toString() + " HashCode = " + ipad.hashCode());
        System.out.println(watch.toString() + " HashCode = " + watch.hashCode());
        iphone.sendMessage("Hello Mary! How are you!", mary);
        samsung.sendMessage("Hi Alex! I'm fine, and you?", alex);
        iphone.charge(2200);
        samsung.charge(2200);
        ipad.charge(2200);
        watch.charge(2200);
     */
    }
}
