import java.text.DecimalFormat;

public class Phone extends Gadget {
    private long phoneNumber;
    private String operatingSystem;
    private CPU cpu;
    private Battery battery;

    public Phone() {
    }

    public Phone(String brand, String model, long phoneNumber) {
        super(brand, model);
        this.phoneNumber = phoneNumber;
    }

    public Phone(String brand, String model, long phoneNumber, String operatingSystem, CPU cpu, Battery battery) {
        super(brand, model);
        this.phoneNumber = phoneNumber;
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.battery = battery;
    }

    public Phone(String type, String brand, String model, String dimensions, String color, int weight, long phoneNumber, String operatingSystem, CPU cpu, Battery battery) {
        super(type, brand, model, dimensions, color, weight);
        this.phoneNumber = phoneNumber;
        this.operatingSystem = operatingSystem;
        this.cpu = cpu;
        this.battery = battery;
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
    public void charging(int chargingCurrent) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float chargingTime = (float) (1.4 * this.battery.getCapacity() / chargingCurrent);
        String result = decimalFormat.format(chargingTime);
        System.out.println("Using this charging current " + chargingCurrent + " (mA), the battery charging time of " + this.getBrand() + " " + this.getModel() + " will be " + result + " h.");
    }

    @Override
    public String toString() {
        return "Phone{" +
                "type='" + this.getType() + '\'' +
                ", brand='" + this.getBrand() + '\'' +
                ", model='" + this.getModel() + '\'' +
                ", dimensions='" + this.getDimensions() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", weight='" + this.getWeight() + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", " + cpu.toString() +
                ", " + battery.toString() +
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
