import java.text.DecimalFormat;

public class SmartWatch extends Gadget {
    private String brand;
    private String model;
    private float displaySize;
    private Battery battery;

    public SmartWatch() {
    }

    public SmartWatch(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public SmartWatch(String brand, String model, float displaySize, Battery battery) {
        this.brand = brand;
        this.model = model;
        this.displaySize = displaySize;
        this.battery = battery;
    }

    public SmartWatch(String name, String dimensions, String color, int weight, String brand, String model, float displaySize, Battery battery) {
        super(name, dimensions, color, weight);
        this.brand = brand;
        this.model = model;
        this.displaySize = displaySize;
        this.battery = battery;
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

    public float getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(float displaySize) {
        this.displaySize = displaySize;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    @Override
    public void printInfo() {
        System.out.println("The " + this.getName() + " " + this.brand + " " + this.model + " has the following characteristics:");
        System.out.println(printSizes());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("The display size of " + this.brand + " " + this.model + " is " + decimalFormat.format(this.displaySize) + " -inch.");
        System.out.println("The color of device is " + this.getColor() + ". The weight is " + this.getWeight() + " g.");
        this.battery.batteryInfo();
    }

    @Override
    public void charging(int chargingCurrent) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float chargingTime = (float) (1.4 * this.battery.getCapacity() / chargingCurrent);
        String result = decimalFormat.format(chargingTime);
        System.out.println("Using this charging current " + chargingCurrent + " (mA), the battery charging time of " + this.brand + " " + this.model + " will be " + result + " h.");
    }

    @Override
    public String toString() {
        return "SmartWatch{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", displaySize=" + displaySize +
                ", " + battery.toString() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        SmartWatch watch = (SmartWatch) obj;

        if (getDisplaySize() != watch.getDisplaySize()) return false;
        if (getBrand() != null ? !getBrand().equals(watch.getBrand()) : watch.getBrand() != null) return false;
        return getModel() != null ? getModel().equals(watch.getModel()) : watch.getModel() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) getDisplaySize();
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
        return result;
    }
}
