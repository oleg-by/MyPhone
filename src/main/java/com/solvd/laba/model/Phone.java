package com.solvd.laba.model;

import com.solvd.laba.enums.Color;
import com.solvd.laba.enums.GadgetName;
import com.solvd.laba.enums.GadgetType;
import com.solvd.laba.interfaces.Camerable;

public class Phone extends Gadget implements Camerable {
    private long phoneNumber;
    private String operatingSystem;
    private Cpu cpu;

    public Phone() {
    }

    public Phone(GadgetName gadgetName, Battery battery, long phoneNumber) {
        super(GadgetType.PHONE, gadgetName, battery);
        this.phoneNumber = phoneNumber;
    }

    public Phone(GadgetName gadgetName, Battery battery, long phoneNumber, String operatingSystem, Cpu cpu) {
        super(GadgetType.PHONE, gadgetName, battery);
        this.phoneNumber = phoneNumber;
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
    }

    public Phone(GadgetName gadgetName, String dimensions, Color color, int weight, Battery battery, long phoneNumber, String operatingSystem, Cpu cpu) {
        super(GadgetType.PHONE, gadgetName, dimensions, color, weight, battery);
        this.phoneNumber = phoneNumber;
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public Cpu getCpu() {
        return cpu;
    }

    @Override
    public String makePhoto(){
        return this.getGadgetName().getGadgetBrand() + " " + this.getGadgetName().getGadgetModel() + " can take photos.";
    }

    @Override
    public String toString() {
        return "Phone{" +
                "type='" + this.getType() + '\'' +
                ", brand='" + this.getGadgetName().getGadgetBrand() + '\'' +
                ", model='" + this.getGadgetName().getGadgetModel() + '\'' +
                ", dimensions='" + this.getDimensions() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", weight='" + this.getWeight() + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", " + cpu.toString() +
                ", " + this.getBattery().toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (getPhoneNumber() != phone.getPhoneNumber()) return false;
        if (!getOperatingSystem().equals(phone.getOperatingSystem())) return false;
        return getCpu().equals(phone.getCpu());
    }

    @Override
    public int hashCode() {
        int result = (int) (getPhoneNumber() ^ (getPhoneNumber() >>> 32));
        result = 31 * result + getOperatingSystem().hashCode();
        result = 31 * result + getCpu().hashCode();
        return result;
    }
}
