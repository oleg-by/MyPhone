package main.java.com.solvd.laba.model;

import main.java.com.solvd.laba.enums.Brand;
import main.java.com.solvd.laba.enums.Color;
import main.java.com.solvd.laba.enums.GadgetType;
import main.java.com.solvd.laba.interfaces.Camerable;

public class Phone extends Gadget implements Camerable {
    private long phoneNumber;
    private String operatingSystem;
    private CPU cpu;

    public Phone() {
    }

    public Phone(Brand brand, String model, Battery battery, long phoneNumber) {
        super(brand, model, battery);
        this.phoneNumber = phoneNumber;
    }

    public Phone(Brand brand, String model, Battery battery, long phoneNumber, String operatingSystem, CPU cpu) {
        super(brand, model, battery);
        this.phoneNumber = phoneNumber;
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
    }

    public Phone(GadgetType type, Brand brand, String model, String dimensions, Color color, int weight, Battery battery, long phoneNumber, String operatingSystem, CPU cpu) {
        super(type, brand, model, dimensions, color, weight, battery);
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

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
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

    @Override
    public String makePhoto(){
        return this.getBrand() + " " + this.getModel() + " can take photos.";
    }

    @Override
    public String toString() {
        return "main.java.model.Phone{" +
                "type='" + this.getType() + '\'' +
                ", brand='" + this.getBrand() + '\'' +
                ", model='" + this.getModel() + '\'' +
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Phone phone = (Phone) obj;

        if (getPhoneNumber() != phone.getPhoneNumber()) return false;
        if (getBrand() != null ? !getBrand().equals(phone.getBrand()) : phone.getBrand() != null) return false;
        return getModel() != null ? getModel().equals(phone.getModel()) : phone.getModel() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) getPhoneNumber();
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
        return result;
    }
}
