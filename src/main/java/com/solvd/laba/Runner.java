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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

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

        Phone iphone = new Phone(GadgetType.PHONE, Brand.APPLE, "Iphone 13 PRO MAX", "160.8 x 78.1 x 7.7", Color.WHITE, 240, batteryList.get(0), 291112233, "iOS", cpuList.get(0));
        LOGGER.info("The object has been created. " + iphone + ".");
        Phone samsung = new Phone(GadgetType.PHONE, Brand.SAMSUNG, "Galaxy S22 Ultra", "163.3 x 77.9 x 8.9", Color.BLUE, 229, batteryList.get(1), 447775566, "Android", cpuList.get(1));
        LOGGER.info("The object has been created. " + samsung + ".");
        Tablet ipad = new Tablet(GadgetType.TABLET, Brand.APPLE, "iPad Pro", "280.6 x 214.9 x 6.4", Color.SILVER, 684, batteryList.get(2), "iPadOS 15", cpuList.get(2), (float) 12.9);
        LOGGER.info("The object has been created. " + ipad + ".");
        SmartWatch watch = new SmartWatch(GadgetType.WATCH, Brand.APPLE, "Watch Series 7", "45 x 38 x 10.7", Color.GREY, 39, batteryList.get(3), (float) 1.9);
        LOGGER.info("The object has been created. " + watch + ".");
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

        // Check the reading data from file (using try with resources)

        File file = new File("D:\\dev\\MyPhone\\src\\main\\java\\com\\solvd\\laba\\input");
        String str = "";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File Not Found Exception caught!");
        }

        // Check the gadget charging

        try {
            Function<String, Integer> valueConverter = x -> Integer.valueOf(x);
            int current = valueConverter.apply(str);
            gadgets.get(0).charge(current);
            gadgets.get(1).charge(current);
            gadgets.get(2).charge(current);
            gadgets.get(3).charge(current);
        } catch (NumberFormatException exception) {
            throw new ChargingException("The string you entered is incorrect.");
        } catch (ChargingException e) {
            LOGGER.error(e.getMessage());
        }

        // Calculate the numbers of the unique words using reading from file

        String path = "D:\\dev\\MyPhone\\src\\main\\java\\com\\solvd\\laba\\article";
        try {
            calculateNumberOfUniqueWords(path);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

        // Check the custom Functional Interfaces

        ICall<Caller, String> call = x -> "I'm calling " + x.getName() + "'s phone number " + x.getCallerID() + ".";
        LOGGER.info(call.callPhoneNumber(alex));
        LOGGER.info(call.callPhoneNumber(mary));

        ICharge<Gadget> myCharge = x -> x.isCharged = true;
        myCharge.chargeGadget(iphone);
        myCharge.chargeGadget(ipad);
        myCharge.chargeGadget(samsung);
        myCharge.chargeGadget(watch);
        if(iphone.isCharged && ipad.isCharged && samsung.isCharged && watch.isCharged){
            LOGGER.info("The charging of my devices was successfully.");
        } else {
            LOGGER.info("Try again!");
        }
    }

    public static void calculateNumberOfUniqueWords(String path) throws IOException {
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
        listOfSeparators.add("\n");
        listOfSeparators.add("\r");
        listOfSeparators.add("\t");

        File file = new File(path);
        List<String> textLines = FileUtils.readLines(file, "UTF-8");
        String separators = String.join("|\\", listOfSeparators);
        Map<String, Word> countMap = new TreeMap<>();

        int i = 0;
        while (i < textLines.size()) {
            String[] words = textLines.get(i).split(separators);
            i++;
            for (String word : words) {
                if ("".equals(word)) {
                    continue;
                }

                Word wordTemp = countMap.get(word);
                if (wordTemp == null) {
                    wordTemp = new Word();
                    wordTemp.word = word;
                    wordTemp.counter = 0;
                    countMap.put(word, wordTemp);
                }

                wordTemp.counter++;
            }

        }

        List<Word> wordsByCount = new ArrayList<>(countMap.values());
        Collections.sort(wordsByCount);
        LOGGER.info("There are " + countMap.size() + " unique words in the article.");
        File fileOutput = new File("D:\\dev\\MyPhone\\src\\main\\java\\com\\solvd\\laba\\output");
        FileUtils.writeLines(fileOutput, wordsByCount);
    }

    public static class Word implements Comparable<Word> {
        String word;
        int counter;

        @Override
        public String toString() {
            return "{" + word + " - " + counter + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Word word1 = (Word) o;

            if (counter != word1.counter) return false;
            return word.equals(word1.word);
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }

        @Override
        public int compareTo(Word w) {
            return w.counter - counter;
        }

    }
}
