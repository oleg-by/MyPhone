import java.text.DecimalFormat;

public abstract class Gadget implements Messenger, Charger, Calling {
    private String type;
    private String brand;
    private String model;
    private String dimensions;
    private String color;
    private int weight;
    private Battery battery;
    private Payment payment;

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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public final void makePayment(Transaction transaction){
        payment.pay(transaction);
    }

    @Override
    public void charge(int chargingCurrent) {
        System.out.println("Starting to charge the " + this.getType() + ".");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float chargingTime = (float) (COEFFICIENT * this.battery.getCapacity() / chargingCurrent);
        String result = decimalFormat.format(chargingTime);
        System.out.println("Using this charging current " + chargingCurrent + " (mA), the battery charging time of " + this.getBrand() + " " + this.getModel() + " will be " + result + " h.");
    }


}
