public class Battery {
    private int capacity;
    private String typeBattery;

    public Battery() {
    }

    public Battery(int capacity) {
        this.capacity = capacity;
    }

    public Battery(int capacity, String typeBattery) {
        this.capacity = capacity;
        this.typeBattery = typeBattery;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTypeBattery(String typeBattery) {
        this.typeBattery = typeBattery;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getTypeBattery() {
        return typeBattery;
    }

    public void batteryInfo() {
        System.out.println("The battery is " + this.typeBattery + ". It has " + this.capacity + " mAh capacity.");
    }

}
