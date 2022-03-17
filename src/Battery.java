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

    @Override
    public String toString() {
        return "Battery{" +
                "capacity=" + capacity +
                ", typeBattery='" + typeBattery + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Battery battery = (Battery) obj;

        if (getCapacity() != battery.getCapacity()) return false;
        return getTypeBattery() != null ? getTypeBattery().equals(battery.getTypeBattery()) : battery.getTypeBattery() == null;
    }

    @Override
    public int hashCode() {
        int result = getCapacity();
        result = 31 * result + (getTypeBattery() != null ? getTypeBattery().hashCode() : 0);
        return result;
    }
}
