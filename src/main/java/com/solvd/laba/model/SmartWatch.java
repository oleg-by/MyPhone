package main.java.com.solvd.laba.model;

import main.java.com.solvd.laba.enums.Brand;
import main.java.com.solvd.laba.enums.Color;
import main.java.com.solvd.laba.enums.GadgetType;

public class SmartWatch extends Gadget {
    private float displaySize;

    public SmartWatch() {
    }

    public SmartWatch(Brand brand, String model, Battery battery, float displaySize) {
        super(brand, model, battery);
        this.displaySize = displaySize;
    }

    public SmartWatch(GadgetType type, Brand brand, String model, String dimensions, Color color, int weight, Battery battery, float displaySize) {
        super(type, brand, model, dimensions, color, weight, battery);
        this.displaySize = displaySize;
    }

    public float getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(float displaySize) {
        this.displaySize = displaySize;
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
                ", " + this.getBattery().toString() +
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
