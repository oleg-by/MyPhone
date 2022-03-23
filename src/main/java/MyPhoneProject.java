package main.java;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyPhoneProject {

    private static final Logger LOGGER = LogManager.getLogger(MyPhoneProject.class);

    public static void main(String[] args) throws ChargingException, BatteryException, AmountTransactionException, CallerIDException {

        LOGGER.info("LOGGER INFO");
        LOGGER.debug("LOGGER DEBUG");
        LOGGER.error("LOGGER ERROR");

        CPU cpuApple = new CPU("Apple A15 Bionic", 3240);
        CPU cpuIpad = new CPU("Apple M1", 3200);
        CPU cpuQualcomm = new CPU("Qualcomm Snapdragon 8 Gen1", 3000);
        Battery batteryApple = new Battery(4325, "Li-ion");
        Battery batterySamsung = new Battery(5000, "Li-ion");
        Battery batteryIpad = new Battery(9720, "Li-ion");
        Battery batteryWatch = new Battery(1094, "Li-ion");
        Phone iphone = new Phone("phone", "Apple", "Iphone 13 PRO MAX", "160.8 x 78.1 x 7.7", "white", 240, batteryApple, 291112233, "iOS", cpuApple);
        Phone samsung = new Phone("phone", "Samsung", "Galaxy S22 Ultra", "163.3 x 77.9 x 8.9", "blue", 229, batterySamsung, 447775566, "Android", cpuQualcomm);
        Tablet ipad = new Tablet("tablet", "Apple", "iPad Pro", "280.6 x 214.9 x 6.4", "silver", 684, batteryIpad, "iPadOS 15", cpuIpad, (float) 12.9);
        SmartWatch watch = new SmartWatch("smart watch", "Apple", "Watch Series 7", "45 x 38 x 10.7", "grey", 39, batteryWatch, (float) 1.9);
        Caller alex = new Caller("Alex", iphone.getPhoneNumber());
        Caller mary = new Caller("Mary", samsung.getPhoneNumber());
        try {
            Transaction[] transactions = new Transaction[4];
            transactions[0] = new Transaction("John Brown", "Bank of America", 100);
            transactions[1] = new Transaction("Jack Russel", "The Bank of New York", 550);
            transactions[2] = new Transaction("Antony Green", "Bank of America", 300);
            transactions[3] = new Transaction("Mary Carry", "The Bank of New York", 250);
            iphone.makePayment(transactions[0]);
            samsung.makePayment(transactions[1]);
            ipad.makePayment(transactions[2]);
            watch.makePayment(transactions[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.error("Array Index Out Of Bounds Exception caught!");;
        }

        File file = new File("D:\\dev\\MyPhone\\src\\main\\java\\test");
        String str = "";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                str = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File Not Found Exception caught!");
        }

        try {
            int current = Integer.parseInt(str);
            iphone.charge(current);
            samsung.charge(current);
            ipad.charge(current);
            watch.charge(current);
        } catch (NumberFormatException exception) {
            throw new ChargingException("The string you entered is incorrect.", exception);
        } catch (ChargingException e) {
            LOGGER.error("Charging Exception caught!");
        }
/*

        iphone.sendMessage("Hello Mary! How are you!", mary);
        System.out.println(iphone.getMessage(alex));

        Camera iphoneTest = new Phone("Apple", "Iphone 13", batteryApple, 292225548);
        iphoneTest.photograph();

 */
    }
}
