package main.java;

import main.java.interfaces.Camerable;

public class Tablet extends Gadget implements Camerable {
    private String operatingSystem;
    private CPU cpu;
    private float displaySize;

    public Tablet() {
    }

    public Tablet(String brand, String model, Battery battery, String operatingSystem, CPU cpu, float displaySize) {
        super(brand, model, battery);
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.displaySize = displaySize;
    }

    public Tablet(String type, String brand, String model, String dimensions, String color, int weight, Battery battery, String operatingSystem, CPU cpu, float displaySize) {
        super(type, brand, model, dimensions, color, weight, battery);
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.displaySize = displaySize;
    }

   public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
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

    public float getDisplaySize() {
        return displaySize;
    }

    @Override
    public String photograph(){
        return this.getBrand() + " " + this.getModel() + " can take photos.";
    }

    @Override
    public String toString() {
        return "main.java.Tablet{" +
                "type='" + this.getType() + '\'' +
                ", brand='" + this.getBrand() + '\'' +
                ", model='" + this.getModel() + '\'' +
                ", dimensions='" + this.getDimensions() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", weight='" + this.getWeight() + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", " + cpu.toString() +
                ", " + this.getBattery().toString() +
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
