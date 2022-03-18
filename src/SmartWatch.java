import java.text.DecimalFormat;

public class SmartWatch extends Gadget {
    private float displaySize;
    private Battery battery;

    public SmartWatch() {
    }

    public SmartWatch(String brand, String model, float displaySize, Battery battery) {
        super(brand, model);
        this.displaySize = displaySize;
        this.battery = battery;
    }

    public SmartWatch(String type, String brand, String model, String dimensions, String color, int weight, float displaySize, Battery battery) {
        super(type, brand, model, dimensions, color, weight);
        this.displaySize = displaySize;
        this.battery = battery;
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
    public void charging(int chargingCurrent) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float chargingTime = (float) (1.4 * this.battery.getCapacity() / chargingCurrent);
        String result = decimalFormat.format(chargingTime);
        System.out.println("Using this charging current " + chargingCurrent + " (mA), the battery charging time of " + this.getBrand() + " " + this.getModel() + " will be " + result + " h.");
    }

    @Override
    public String toString() {
        return "SmartWatch{" +
                "type='" + this.getType() + '\'' +
                ", brand='" + this.getBrand() + '\'' +
                ", model='" + this.getModel() + '\'' +
                ", dimensions='" + this.getDimensions() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", weight='" + this.getWeight() + '\'' +
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
