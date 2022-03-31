package main.java;

import main.java.exceptions.AmountTransactionException;
import main.java.exceptions.BatteryException;
import main.java.exceptions.CallerIDException;
import main.java.exceptions.ChargingException;
import main.java.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyPhoneProject {

    private static final Logger LOGGER = LogManager.getLogger(MyPhoneProject.class);

    public static void main(String[] args) throws ChargingException, BatteryException, AmountTransactionException, CallerIDException {

        List<CPU> cpuList = new ArrayList<>();
        cpuList.add(new CPU("Apple A15 Bionic", 3240));
        cpuList.add(new CPU("Qualcomm Snapdragon 8 Gen1", 3000));
        cpuList.add(new CPU("Apple M1", 3200));

        List<Battery> batteryList = new ArrayList<>();
        batteryList.add(new Battery(4325, "Li-ion"));
        batteryList.add(new Battery(5000, "Li-ion"));
        batteryList.add(new Battery(9720, "Li-ion"));
        batteryList.add(new Battery(1094, "Li-ion"));

        Phone iphone = new Phone("phone", "Apple", "Iphone 13 PRO MAX", "160.8 x 78.1 x 7.7", "white", 240, batteryList.get(0), 291112233, "iOS", cpuList.get(0));
        LOGGER.info("The object has been created. " + iphone.toString() + ".");
        Phone samsung = new Phone("phone", "Samsung", "Galaxy S22 Ultra", "163.3 x 77.9 x 8.9", "blue", 229, batteryList.get(1), 447775566, "Android", cpuList.get(1));
        LOGGER.info("The object has been created. " + samsung.toString() + ".");
        Tablet ipad = new Tablet("tablet", "Apple", "iPad Pro", "280.6 x 214.9 x 6.4", "silver", 684, batteryList.get(2), "iPadOS 15", cpuList.get(2), (float) 12.9);
        LOGGER.info("The object has been created. " + ipad.toString() + ".");
        SmartWatch watch = new SmartWatch("smart watch", "Apple", "Watch Series 7", "45 x 38 x 10.7", "grey", 39, batteryList.get(3), (float) 1.9);
        LOGGER.info("The object has been created." + watch.toString() + ".");
        Caller alex = new Caller("Alex", iphone.getPhoneNumber());
        Caller mary = new Caller("Mary", samsung.getPhoneNumber());

        //Use custom Linked List

        LinkedList<Gadget> gadgets = new LinkedList<>();
        gadgets.addLast(iphone);
        gadgets.addLast(samsung);
        gadgets.addLast(ipad);
        gadgets.addLast(watch);
        LOGGER.info("The size of Gadget Linked List is " + gadgets.size() + ".");

        // Check the payment systems

        try {
            List<Transaction> transactionList = new ArrayList<>();
            transactionList.add(new Transaction("John Brown", "Bank of America", 50));
            transactionList.add(new Transaction("Jack Russel", "The Bank of New York", 550));
            transactionList.add(new Transaction("Antony Green", "Bank of America", 300));
            transactionList.add(new Transaction("Mary Carry", "The Bank of New York", 250));

            gadgets.get(0).makePayment(transactionList.get(0));
            gadgets.get(1).makePayment(transactionList.get(1));
            gadgets.get(2).makePayment(transactionList.get(2));
            gadgets.get(3).makePayment(transactionList.get(3));

        } catch (AmountTransactionException e) {
            LOGGER.error(e.getMessage());
        }

        // Check the reading data from file

        File file = new File("D:\\dev\\MyPhone\\src\\main\\java\\test");
        String str = "";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File Not Found Exception caught!");
        }

        // Check the charging

        try {
            int current = Integer.parseInt(str);
            gadgets.get(0).charge(current);
            gadgets.get(1).charge(current);
            gadgets.get(2).charge(current);
            gadgets.get(3).charge(current);
        } catch (NumberFormatException exception) {
            throw new ChargingException("The string you entered is incorrect.");
        } catch (ChargingException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
