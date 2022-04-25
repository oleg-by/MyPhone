package main.java.com.solvd.laba;

import main.java.com.solvd.laba.enums.Color;
import main.java.com.solvd.laba.enums.GadgetName;
import main.java.com.solvd.laba.enums.GadgetType;
import main.java.com.solvd.laba.exceptions.AmountTransactionException;
import main.java.com.solvd.laba.exceptions.BatteryException;
import main.java.com.solvd.laba.exceptions.CallerIDException;
import main.java.com.solvd.laba.exceptions.ChargingException;
import main.java.com.solvd.laba.interfaces.functional.*;
import main.java.com.solvd.laba.linkedlist.LinkedList;
import main.java.com.solvd.laba.model.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {

        // Create the objects and add them to a custom Linked List
        List<Gadget> gadgets = createObjects();

        // Check the payment systems of objects (gadgets)
        checkPayment(gadgets);

        // Check the gadget charging of objects (gadgets)
        try {
            checkCharging(gadgets);
        } catch (ChargingException e) {
            LOGGER.error(e.getMessage());
        }

        // Check the using custom LinkedList
        checkMyLinkedList(gadgets);

        // Check the using custom Functional Interfaces
        checkFunctionalInterface(gadgets);

        // Calculate the numbers of the unique words using reading from file
        calculateNumberOfUniqueWords();

        // Check the using Stream
        checkMyStreams(gadgets);

        // Check the Reflection with Class Caller
        checkMyReflection();
    }

    public static List<Gadget> createObjects() {
        List<Cpu> cpuList = new ArrayList<>();
        cpuList.add(new Cpu("Apple A15 Bionic", 3240));
        cpuList.add(new Cpu("Qualcomm Snapdragon 8 Gen1", 3000));
        cpuList.add(new Cpu("Apple M1", 3200));
        cpuList.add(new Cpu("Qualcomm Snapdragon 888", 2840));
        cpuList.add(new Cpu("HiSilicon Kirin 990 5G", 2860));

        List<Battery> batteryList = new ArrayList<>();
        try {
            batteryList.add(new Battery(4325, "Li-ion"));
            batteryList.add(new Battery(5000, "Li-ion"));
            batteryList.add(new Battery(9720, "Li-ion"));
            batteryList.add(new Battery(1094, "Li-ion"));
            batteryList.add(new Battery(4360, "Li-ion"));
            batteryList.add(new Battery(4500, "Li-ion"));
            batteryList.add(new Battery(4000, "Li-ion"));
        } catch (BatteryException e) {
            LOGGER.error(e.getMessage());
        }

        //Using enums fields
        Phone iphone = new Phone(GadgetName.IPHONE, "160.8 x 78.1 x 7.7", Color.WHITE, 240, batteryList.get(0), 291112233, "iOS", cpuList.get(0));
        Phone samsung = new Phone(GadgetName.SAMS, "163.3 x 77.9 x 8.9", Color.BLUE, 229, batteryList.get(1), 447775566, "Android", cpuList.get(1));
        Tablet ipad = new Tablet(GadgetName.IPAD, "280.6 x 214.9 x 6.4", Color.WHITE, 684, batteryList.get(2), "iPadOS 15", cpuList.get(2), (float) 12.9);
        SmartWatch watch = new SmartWatch(GadgetName.IWATCH, "45 x 38 x 10.7", Color.GREY, 39, batteryList.get(3), (float) 1.9);
        Phone xiaomi = new Phone(GadgetName.MI11, "164.3 x 74.6 x 8.38", Color.WHITE, 234, batteryList.get(1), 296666222, "Android", cpuList.get(3));
        Phone huawei = new Phone(GadgetName.HUA, "158.8 x 72.8 x 8.5", Color.GREEN, 195, batteryList.get(4), 335059905, "Android", cpuList.get(3));
        Phone sony = new Phone(GadgetName.SONYXP, "166 x 72 x 8.9", Color.SILVER, 211, batteryList.get(5), 296060103, "Android", cpuList.get(3));
        Phone honor = new Phone(GadgetName.HONOR30, "160.3 x 73.6 x 8.38", Color.BLACK, 190, batteryList.get(6), 332020327, "Android", cpuList.get(4));

        List<Gadget> myGadgets = new ArrayList<>();
        myGadgets.add(iphone);
        myGadgets.add(samsung);
        myGadgets.add(ipad);
        myGadgets.add(watch);
        myGadgets.add(xiaomi);
        myGadgets.add(huawei);
        myGadgets.add(sony);
        myGadgets.add(honor);
        LOGGER.info("The " + myGadgets.size() + " objects have been created.");
        return myGadgets;
    }

    public static void checkPayment(List<Gadget> myGadgets) {
        try {
            List<Transaction> transactionList = new ArrayList<>();
            transactionList.add(new Transaction("John Brown", "Bank of America", 50));
            transactionList.add(new Transaction("Jack Russel", "The Bank of New York", 550));
            transactionList.add(new Transaction("Antony Green", "Bank of America", 300));
            transactionList.add(new Transaction("Mary Carry", "The Bank of New York", 250));
            for (Gadget g : myGadgets) {
                int i = (int) (3 * Math.random());
                g.makePayment(transactionList.get(i));
            }
        } catch (AmountTransactionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void checkCharging(List<Gadget> myGadgets) throws ChargingException {
        File file = new File("D:\\dev\\MyPhone\\src\\main\\resources\\inputCurrent");
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
            // Use lambda with F.I. Function
            Function<String, Integer> valueConverter = Integer::valueOf;
            int current = valueConverter.apply(str);
            for (Gadget g : myGadgets) {
                g.charge(current);
            }
        } catch (NumberFormatException exception) {
            throw new ChargingException("The string you entered is incorrect.");
        } catch (ChargingException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void checkMyLinkedList(List<Gadget> myGadgets) {
        LinkedList<Gadget> myLinkedList = new LinkedList<>();
        for (Gadget g : myGadgets) {
            myLinkedList.addLast(g);
        }
        LOGGER.info(myLinkedList);
        LOGGER.info("The size of my custom Linked List: " + myLinkedList.getSize());
        myLinkedList.remove(myGadgets.get(2));
        LOGGER.info("The size of my custom Linked List after deleting one element: " + myLinkedList.getSize());
        Battery bat = null;
        try {
            bat = new Battery(5000, "Li-ion");
        } catch (BatteryException e) {
            LOGGER.error(e.getMessage());
        }
        Phone xiaomiTest = new Phone(GadgetName.MI11, "164.3 x 74.6 x 8.38", Color.BLUE, 234, bat, 293323666, "Android", new Cpu("Qualcomm Snapdragon 888", 2840));
        myLinkedList.addFirst(xiaomiTest);
        LOGGER.info(myLinkedList);
        LOGGER.info("The size of my custom Linked List after adding one element: " + myLinkedList.getSize());
    }

    public static void checkFunctionalInterface(List<Gadget> myGadgets) {
        Caller alex = null;
        Caller mary = null;
        try {
            alex = new Caller("Alex", 291112233);
            mary = new Caller("Mary", 447775566);
        } catch (CallerIDException e) {
            LOGGER.error(e.getMessage());
        }

        ICall<Caller, String> call = x -> "I'm calling " + x.getName() + "'s phone number " + x.getCallerID() + ".";
        LOGGER.info(call.callPhoneNumber(alex));
        LOGGER.info(call.callPhoneNumber(mary));

        ICharge<Gadget> myCharge = x -> x.isCharged = true;
        for (Gadget g : myGadgets) {
            myCharge.chargeGadget(g);
        }
        if (myGadgets.get(0).isCharged && myGadgets.get(1).isCharged && myGadgets.get(2).isCharged && myGadgets.get(3).isCharged) {
            LOGGER.info("The charging of my devices was successfully.");
        } else {
            LOGGER.info("Try again!");
        }

        IFormat f = x -> "+375" + x;
        if (alex != null && mary != null) {
            LOGGER.info(f.formatNumber(alex.getCallerID()));
            LOGGER.info(f.formatNumber(mary.getCallerID()));
        }

        ICompare<Phone, Phone> test = (x, y) -> {
            int xPointer = 0;
            int yPointer = 0;
            if (x.getWeight() < y.getWeight()) {
                xPointer++;
            } else if (x.getWeight() != y.getWeight()) {
                yPointer++;
            }
            if (x.getBattery().getCapacity() > y.getBattery().getCapacity()) {
                xPointer++;
            } else if (x.getBattery().getCapacity() != y.getBattery().getCapacity()) {
                yPointer++;
            }
            if (x.getCpu().getCpuSpeed() > y.getCpu().getCpuSpeed()) {
                xPointer++;
            } else if (x.getCpu().getCpuSpeed() != y.getCpu().getCpuSpeed()) {
                yPointer++;
            }
            if (xPointer > yPointer) {
                return x.getGadgetName() + " is better than " + y.getGadgetName();
            } else if (xPointer == yPointer) {
                return "The characteristics of the models are similar.";
            } else return y.getGadgetName() + " is better than " + x.getGadgetName();
        };
        LOGGER.info(test.compareGadgets((Phone) myGadgets.get(0), (Phone) myGadgets.get(1)));

        IConvert inchToCm = x -> (float) 2.54 * x;
        LOGGER.info("12.9 in. is equal to " + inchToCm.convertDisplaySize((float) 12.9) + " cm.");
    }

    public static void calculateNumberOfUniqueWords() {
        String path = "D:\\dev\\MyPhone\\src\\main\\resources\\article";
        File file = new File(path);
        String text = null;
        try {
            text = StringUtils.lowerCase(FileUtils.readFileToString(file, "UTF-8"))
                    .replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        String[] words = new String[0];
        if (text != null) {
            words = text.split(" ");
        }
        Map<String, Integer> map = new TreeMap<>();
        for (String word : words) {
            map.put(word, StringUtils.countMatches(text, word));
        }
        LOGGER.info("There are " + map.size() + " unique words in the article.");
        LOGGER.info("Please, see the OUTPUT file in your directory \\main\\resources.");
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getKey() + " - " + entry.getValue());
        }
        File fileOutput = new File("D:\\dev\\MyPhone\\src\\main\\resources\\output");
        try {
            FileUtils.writeLines(fileOutput, result);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void checkMyStreams(List<Gadget> myGadgets) {
        // Show objects that have a battery capacity greater than 5000, and sorted by them weight.
        LOGGER.info("#1 task");
        myGadgets.stream()
                .filter(gadget -> gadget.getBattery().getCapacity() >= 5000)
                .sorted(Comparator.comparing(Gadget::getWeight))
                .forEach(LOGGER::info);

        // Create List of objects "Apple".
        LOGGER.info("#2 task");
        List<Gadget> appleList = myGadgets.stream()
                .filter(gadget -> gadget.getGadgetName().getGadgetBrand().getName().equals("Apple"))
                .collect(Collectors.toList());
        for (Gadget g : appleList) {
            LOGGER.info(g);
        }

        // Count the number of white phones.
        LOGGER.info("#3 task");
        long count = myGadgets.stream().filter(gadget -> gadget.getColor().equals(Color.WHITE)
                && gadget.getType().equals(GadgetType.PHONE))
                .count();
        LOGGER.info("The number of white phones: " + count);
    }

    public static void checkMyReflection() {
        LOGGER.info("Print info about Class: " + Caller.class.getName() + ".");
        Constructor[] constructors = Caller.class.getDeclaredConstructors();
        Caller caller = null;
        try {
            caller = (Caller) constructors[0].newInstance();
        } catch (InstantiationException e) {
            LOGGER.error(e.getMessage());
        } catch (IllegalAccessException e) {
            LOGGER.error(e.getMessage());
        } catch (InvocationTargetException e) {
            LOGGER.error(e.getMessage());
        }

        Field[] fields = new Field[0];
        if (caller != null) {
            fields = caller.getClass().getDeclaredFields();
        }
        int i = 1;
        for (Field field : fields) {
            LOGGER.info("Field " + i + ": " + field.getName());
            i++;
        }
        Method[] methods = new Method[0];
        if (caller != null) {
            methods = caller.getClass().getDeclaredMethods();
        }
        i = 1;
        for (Method method : methods) {
            LOGGER.info("Method " + i + ": " + method.getName());
            i++;
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                LOGGER.info("Its parameters: " + parameter.getName() + "; type: " + parameter.getType().getName());
            }
        }
    }
}
