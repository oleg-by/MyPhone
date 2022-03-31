package main.java.model;

import main.java.exceptions.ChargingException;
import main.java.exceptions.TransactionException;
import main.java.interfaces.Callable;
import main.java.interfaces.Chargerable;
import main.java.interfaces.Messengable;
import main.java.interfaces.Payable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;

public abstract class Gadget implements Messengable, Chargerable, Callable {

    private static final Logger LOGGER = LogManager.getLogger(Gadget.class);

    private String type;
    private String brand;
    private String model;
    private String dimensions;
    private String color;
    private int weight;
    private Battery battery;
    private Payable payment;

    public Gadget() {

    }

    public Gadget(String brand, String model, Battery battery) {
        this.brand = brand;
        this.model = model;
        this.battery = battery;
        if(brand.equals("Apple")) {this.payment = new ApplePay();}
        else if(brand.equals("Samsung")) {this.payment = new SamsungPay();} else {this.payment = new MiPay();}
    }

    public Gadget(String type, String brand, String model, String dimensions, String color, int weight, Battery battery) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.dimensions = dimensions;
        this.color = color;
        this.weight = weight;
        this.battery = battery;
        if(brand.equals("Apple")) {this.payment = new ApplePay();}
        else if(brand.equals("Samsung")) {this.payment = new SamsungPay();} else {this.payment = new MiPay();}
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public String getType() {
        return type;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public Battery getBattery() {
        return battery;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Payable getPayment() {
        return payment;
    }

    public void setPayment(Payable payment) {
        this.payment = payment;
    }

    public final void makePayment(Transaction transaction){
        try {
            LOGGER.info(payment.pay(transaction));
        } catch (TransactionException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void charge(int chargingCurrent) throws ChargingException {
        if (chargingCurrent <= 0){
            throw new ChargingException("The charging current is incorrect!");
        } else {
            LOGGER.info("Starting to charge the " + this.getType() + ".");
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            float chargingTime = COEFFICIENT * this.battery.getCapacity() / chargingCurrent;
            String result = decimalFormat.format(chargingTime);
            LOGGER.info("Using this charging current " + chargingCurrent + " (mA), the battery charging time of " + this.getBrand() + " " + this.getModel() + " will be " + result + " h.");
        }
    }


}
