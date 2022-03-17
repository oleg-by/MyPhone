import java.text.DecimalFormat;

public class Tablet extends Gadget {
    private String brand;
    private String model;
    private String operatingSystem;
    private CPU cpu;
    private Battery battery;
    private float displaySize;

    public Tablet() {
    }

    public Tablet(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Tablet(String brand, String model, String operatingSystem, CPU cpu, Battery battery, float displaySize) {
        this.brand = brand;
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.battery = battery;
        this.displaySize = displaySize;
    }

    public Tablet(String name, String dimensions, String color, int weight, String brand, String model, String operatingSystem, CPU cpu, Battery battery, float displaySize) {
        super(name, dimensions, color, weight);
        this.brand = brand;
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.battery = battery;
        this.displaySize = displaySize;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
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

    public void setDisplaySize(float displaySize) {
        this.displaySize = displaySize;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
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

    public float getDisplaySize() {
        return displaySize;
    }

    @Override
    public void printInfo() {
        System.out.println("The " + this.getName() + " " + this.brand + " " + this.model + " has the following characteristics:");
        System.out.println(printSizes());
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        System.out.println("The display size of " + this.brand + " " + this.model + " is " + decimalFormat.format(this.displaySize) + " -inch.");
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

    @Override
    public String toString() {
        return "Tablet{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", " + cpu.toString() +
                ", " + battery.toString() +
                ", displaySize=" + displaySize +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Tablet tablet = (Tablet) obj;

        if (getDisplaySize() != tablet.getDisplaySize()) return false;
        if (getBrand() != null ? !getBrand().equals(tablet.getBrand()) : tablet.getBrand() != null) return false;
        if (getModel() != null ? !getModel().equals(tablet.getModel()) : tablet.getModel() != null) return false;
        return getOperatingSystem() != null ? getOperatingSystem().equals(tablet.getOperatingSystem()) : tablet.getOperatingSystem() == null;
    }

    @Override
    public int hashCode() {
        int result = (int)getDisplaySize();
        result = 31 * result + ((model == null) ? 0 : model.hashCode());
        result = 31 * result + ((operatingSystem == null) ? 0 : operatingSystem.hashCode());
        result = 31 * result + ((brand == null) ? 0 : brand.hashCode());
        return result;
    }
}
