import java.text.DecimalFormat;

public class Phone extends Gadget {
    private String brand;
    private String model;
    private long phoneNumber;
    private String operatingSystem;
    private CPU cpu;
    private Battery battery;

    public Phone() {
    }

    public Phone(String brand, String model, long phoneNumber) {
        this.brand = brand;
        this.model = model;
        this.phoneNumber = phoneNumber;
    }

    public Phone(String brand, String model, long phoneNumber, String operatingSystem, CPU cpu, Battery battery) {
        this.brand = brand;
        this.model = model;
        this.phoneNumber = phoneNumber;
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.battery = battery;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Battery getBattery() {
        return battery;
    }

    public void calling(Caller caller) {
        System.out.println("Outgoing call to " + caller.getName() + " at number " + caller.getCallerID() + "...");
    }

    public void calling(long number) {
        System.out.println("The number " + number + " you are calling is currently unavailable...");
    }

    public void sendMessage(String message, Caller caller) {
        System.out.println("The message (" + message + ") has been sent to subscriber " + caller.getName() + " at number " + caller.getCallerID() + ".");
    }

    public void sendMessage(String message, long number) {
        System.out.println("The message (" + message + ") has been sent to subscriber at number " + number + ".");
    }

    @Override
    public void printInfo() {
        System.out.println("The " + this.getName() + " " + this.brand + " " + this.model + " has the following characteristics:");
        System.out.println(printSizes());
        System.out.println("The color of device is " + this.getColor() + ". The weight is " + this.getWeight() + " g.");
        System.out.println("The " + this.brand + " " + this.model + " runs on the " + this.operatingSystem + " operating system.");
        this.cpu.cpuInfo();
        this.battery.batteryInfo();
    }

    @Override
    public void charging(int chargingCurrent) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float chargingTime = (float) (1.4 * this.battery.getCapacity() / chargingCurrent);
        String result = decimalFormat.format(chargingTime);
        System.out.println("Using this charging current " + chargingCurrent + " (mA), the battery charging time of " + this.brand + " " + this.model + " will be " + result + " h.");
    }

}
