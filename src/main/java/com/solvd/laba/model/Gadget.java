package main.java.com.solvd.laba.model;

import main.java.com.solvd.laba.enums.Color;
import main.java.com.solvd.laba.enums.GadgetName;
import main.java.com.solvd.laba.enums.GadgetType;
import main.java.com.solvd.laba.exceptions.ChargingException;
import main.java.com.solvd.laba.exceptions.TransactionException;
import main.java.com.solvd.laba.interfaces.Callable;
import main.java.com.solvd.laba.interfaces.Chargerable;
import main.java.com.solvd.laba.interfaces.Messengable;
import main.java.com.solvd.laba.interfaces.Payable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;

public abstract class Gadget implements Messengable, Chargerable, Callable {

    private static final Logger LOGGER = LogManager.getLogger(Gadget.class);

    private GadgetType type;
    private GadgetName gadgetName;
    private String dimensions;
    private Color color;
    private int weight;
    private Battery battery;
    private Payable payment;

    public boolean isCharged = false;

    public Gadget() {

    }

    public Gadget(GadgetType type, GadgetName gadgetName, Battery battery) {
        this.type = type;
        this.gadgetName = gadgetName;
        this.battery = battery;
        switch (gadgetName.getGadgetBrand()){
            case APPLE: this.payment = new ApplePay(); break;
            case SAMSUNG: this.payment = new SamsungPay(); break;
            case XIAOMI: this.payment = new MiPay(); break;
            default: this.payment = new DefaultPay(); break;
        }
    }

    public Gadget(GadgetType type, GadgetName gadgetName, String dimensions, Color color, int weight, Battery battery) {
        this.type = type;
        this.gadgetName = gadgetName;
        this.dimensions = dimensions;
        this.color = color;
        this.weight = weight;
        this.battery = battery;
        switch (gadgetName.getGadgetBrand()){
            case APPLE: this.payment = new ApplePay(); break;
            case SAMSUNG: this.payment = new SamsungPay(); break;
            case XIAOMI: this.payment = new MiPay(); break;
            default: this.payment = new DefaultPay(); break;
        }
    }

    public void setType(GadgetType type) {
        this.type = type;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public GadgetType getType() {
        return type;
    }

    public String getDimensions() {
        return dimensions;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public Battery getBattery() {
        return battery;
    }

    public GadgetName getGadgetName() {
        return gadgetName;
    }

    public void setGadgetName(GadgetName gadgetName) {
        this.gadgetName = gadgetName;
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
            LOGGER.info("Using this charging current " + chargingCurrent + " (mA), the battery charging time of "
                    + this.gadgetName.getGadgetBrand() + " " + this.gadgetName.getGadgetModel()
                    + " will be " + result + " h.");
        }
    }


}
