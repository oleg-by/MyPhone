package main.java.com.solvd.laba;

import main.java.com.solvd.laba.enums.Brand;
import main.java.com.solvd.laba.enums.Color;
import main.java.com.solvd.laba.enums.GadgetType;
import main.java.com.solvd.laba.exceptions.AmountTransactionException;
import main.java.com.solvd.laba.exceptions.BatteryException;
import main.java.com.solvd.laba.exceptions.CallerIDException;
import main.java.com.solvd.laba.exceptions.ChargingException;
import main.java.com.solvd.laba.interfaces.ICall;
import main.java.com.solvd.laba.interfaces.ICharge;
import main.java.com.solvd.laba.model.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws ChargingException, AmountTransactionException, BatteryException, CallerIDException {

        // Create the objects and add them to a custom Linked List
        LinkedList<Gadget> gadgets = createObjects();

        // Check the payment systems of objects (gadgets)
        checkPayment(gadgets);

        // Check the gadget charging of objects (gadgets)
        checkCharging(gadgets);

        // Check the using custom Functional Interfaces
        checkFunctionalInterface(gadgets);

        // Calculate the numbers of the unique words using reading from file
        calculateNumberOfUniqueWords();
    }

    public static LinkedList<Gadget> createObjects() throws BatteryException {
        List<Cpu> cpuList = new ArrayList<>();
        cpuList.add(new Cpu("Apple A15 Bionic", 3240));
        cpuList.add(new Cpu("Qualcomm Snapdragon 8 Gen1", 3000));
        cpuList.add(new Cpu("Apple M1", 3200));
        List<Battery> batteryList = new ArrayList<>();
        batteryList.add(new Battery(4325, "Li-ion"));
        batteryList.add(new Battery(5000, "Li-ion"));
        batteryList.add(new Battery(9720, "Li-ion"));
        batteryList.add(new Battery(1094, "Li-ion"));

        //Using enums fields
        Phone iphone = new Phone(GadgetType.PHONE, Brand.APPLE, "Iphone 13 PRO MAX", "160.8 x 78.1 x 7.7", Color.WHITE, 240, batteryList.get(0), 291112233, "iOS", cpuList.get(0));
        Phone samsung = new Phone(GadgetType.PHONE, Brand.SAMSUNG, "Galaxy S22 Ultra", "163.3 x 77.9 x 8.9", Color.BLUE, 229, batteryList.get(1), 447775566, "Android", cpuList.get(1));
        Tablet ipad = new Tablet(GadgetType.TABLET, Brand.APPLE, "iPad Pro", "280.6 x 214.9 x 6.4", Color.SILVER, 684, batteryList.get(2), "iPadOS 15", cpuList.get(2), (float) 12.9);
        SmartWatch watch = new SmartWatch(GadgetType.WATCH, Brand.APPLE, "Watch Series 7", "45 x 38 x 10.7", Color.GREY, 39, batteryList.get(3), (float) 1.9);

        //Use custom LinkedList
        LinkedList<Gadget> myGadgets = new LinkedList<>();
        myGadgets.addLast(iphone);
        myGadgets.addLast(samsung);
        myGadgets.addLast(ipad);
        myGadgets.addLast(watch);
        LOGGER.info("The " + myGadgets.size() + " objects have been created.");
        return myGadgets;
    }

    public static void checkPayment(LinkedList<Gadget> myGadgets) {
        try {
            List<Transaction> transactionList = new ArrayList<>();
            transactionList.add(new Transaction("John Brown", "Bank of America", 50));
            transactionList.add(new Transaction("Jack Russel", "The Bank of New York", 550));
            transactionList.add(new Transaction("Antony Green", "Bank of America", 300));
            transactionList.add(new Transaction("Mary Carry", "The Bank of New York", 250));
            myGadgets.get(0).makePayment(transactionList.get(0));
            myGadgets.get(1).makePayment(transactionList.get(1));
            myGadgets.get(2).makePayment(transactionList.get(2));
            myGadgets.get(3).makePayment(transactionList.get(3));
        } catch (AmountTransactionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void checkCharging(LinkedList<Gadget> myGadgets) throws ChargingException {
        File file = new File("D:\\dev\\MyPhone\\src\\main\\java\\com\\solvd\\laba\\input");
        String str = "";
        // Read data from file (using try with resources)
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File Not Found Exception caught!");
        }
        try {
            // Use lambda
            Function<String, Integer> valueConverter = Integer::valueOf;
            int current = valueConverter.apply(str);
            myGadgets.get(0).charge(current);
            myGadgets.get(1).charge(current);
            myGadgets.get(2).charge(current);
            myGadgets.get(3).charge(current);
        } catch (NumberFormatException exception) {
            throw new ChargingException("The string you entered is incorrect.");
        } catch (ChargingException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void checkFunctionalInterface(LinkedList<Gadget> myGadgets) throws CallerIDException {
        Caller alex = new Caller("Alex", 291112233);
        Caller mary = new Caller("Mary", 447775566);

        ICall<Caller, String> call = x -> "I'm calling " + x.getName() + "'s phone number " + x.getCallerID() + ".";
        LOGGER.info(call.callPhoneNumber(alex));
        LOGGER.info(call.callPhoneNumber(mary));

        ICharge<Gadget> myCharge = x -> x.isCharged = true;
        myCharge.chargeGadget(myGadgets.get(0));
        myCharge.chargeGadget(myGadgets.get(1));
        myCharge.chargeGadget(myGadgets.get(2));
        myCharge.chargeGadget(myGadgets.get(3));
        if (myGadgets.get(0).isCharged && myGadgets.get(1).isCharged && myGadgets.get(2).isCharged && myGadgets.get(3).isCharged) {
            LOGGER.info("The charging of my devices was successfully.");
        } else {
            LOGGER.info("Try again!");
        }
    }

    public static void calculateNumberOfUniqueWords() {
        String path = "D:\\dev\\MyPhone\\src\\main\\java\\com\\solvd\\laba\\article";
        ArrayList<String> listOfSeparators = new ArrayList<>();
        listOfSeparators.add(" ");
        listOfSeparators.add(",");
        listOfSeparators.add(".");
        listOfSeparators.add("!");
        listOfSeparators.add("?");
        listOfSeparators.add("(");
        listOfSeparators.add(")");
        listOfSeparators.add("[");
        listOfSeparators.add("]");
        listOfSeparators.add("-");
        listOfSeparators.add(";");
        listOfSeparators.add(":");
        listOfSeparators.add("/");
        listOfSeparators.add("}");
        listOfSeparators.add("{");
        listOfSeparators.add("\n");
        listOfSeparators.add("\r");
        listOfSeparators.add("\t");
        File file = new File(path);
        String text = null;
        try {
            text = StringUtils.lowerCase(FileUtils.readFileToString(file, "UTF-8"));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        String separators = String.join("|\\", listOfSeparators);
        String[] words = StringUtils.split(text, separators);
        Map<String, Integer> map = new TreeMap<>();
        if (words != null) {
            for (String word : words) {
                map.put(word, StringUtils.countMatches(text, word));
            }
        }
        LOGGER.info("There are " + map.size() + " unique words in the article.");
        LOGGER.info("Please, see the OUTPUT file in your directory \\main\\java\\com\\solvd\\laba.");
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getKey() + " - " + entry.getValue());
        }
        File fileOutput = new File("D:\\dev\\MyPhone\\src\\main\\java\\com\\solvd\\laba\\output");
        try {
            FileUtils.writeLines(fileOutput, result);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
