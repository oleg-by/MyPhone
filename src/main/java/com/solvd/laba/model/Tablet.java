package com.solvd.laba.model;

import com.solvd.laba.enums.Color;
import com.solvd.laba.enums.GadgetName;
import com.solvd.laba.enums.GadgetType;
import com.solvd.laba.interfaces.Camerable;

public class Tablet extends Gadget implements Camerable {
    private String operatingSystem;
    private Cpu cpu;
    private float displaySize;

    public Tablet() {
    }

    public Tablet(GadgetName gadgetName, Battery battery, String operatingSystem, Cpu cpu, float displaySize) {
        super(GadgetType.TABLET, gadgetName, battery);
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.displaySize = displaySize;
    }

    public Tablet(GadgetName gadgetName, String dimensions, Color color, int weight, Battery battery, String operatingSystem, Cpu cpu, float displaySize) {
        super(GadgetType.TABLET, gadgetName, dimensions, color, weight, battery);
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.displaySize = displaySize;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public void setDisplaySize(float displaySize) {
        this.displaySize = displaySize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public float getDisplaySize() {
        return displaySize;
    }

    @Override
    public String makePhoto() {
        return this.getGadgetName().getGadgetBrand() + " " + this.getGadgetName().getGadgetModel() + " can take photos.";
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "type='" + this.getType() + '\'' +
                ", brand='" + this.getGadgetName().getGadgetBrand() + '\'' +
                ", model='" + this.getGadgetName().getGadgetModel() + '\'' +
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tablet tablet = (Tablet) o;

        if (Float.compare(tablet.getDisplaySize(), getDisplaySize()) != 0) return false;
        if (!getOperatingSystem().equals(tablet.getOperatingSystem())) return false;
        return getCpu().equals(tablet.getCpu());
    }

    @Override
    public int hashCode() {
        int result = getOperatingSystem().hashCode();
        result = 31 * result + getCpu().hashCode();
        result = 31 * result + (getDisplaySize() != 0.0f ? Float.floatToIntBits(getDisplaySize()) : 0);
        return result;
    }
}
