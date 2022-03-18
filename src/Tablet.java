import java.text.DecimalFormat;

public class Tablet extends Gadget {
    private String operatingSystem;
    private CPU cpu;
    private Battery battery;
    private float displaySize;

    public Tablet() {
    }

    public Tablet(String brand, String model, String operatingSystem, CPU cpu, Battery battery, float displaySize) {
        super(brand, model);
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.battery = battery;
        this.displaySize = displaySize;
    }

    public Tablet(String type, String brand, String model, String dimensions, String color, int weight, String operatingSystem, CPU cpu, Battery battery, float displaySize) {
        super(type, brand, model, dimensions, color, weight);
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.battery = battery;
        this.displaySize = displaySize;
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
    public void charging(int chargingCurrent) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float chargingTime = (float) (1.4 * this.battery.getCapacity() / chargingCurrent);
        String result = decimalFormat.format(chargingTime);
        System.out.println("Using this charging current " + chargingCurrent + " (mA), the battery charging time of " + this.getBrand() + " " + this.getModel() + " will be " + result + " h.");
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "type='" + this.getType() + '\'' +
                ", brand='" + this.getBrand() + '\'' +
                ", model='" + this.getModel() + '\'' +
                ", dimensions='" + this.getDimensions() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", weight='" + this.getWeight() + '\'' +
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
        result = 31 * result + ((getModel() == null) ? 0 : getModel().hashCode());
        result = 31 * result + ((operatingSystem == null) ? 0 : operatingSystem.hashCode());
        result = 31 * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        return result;
    }
}
