public abstract class Gadget {
    private String name;
    private String dimensions;
    private String color;
    private int weight;

    public void setName(String name) {
        this.name = name;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public String printSizes() {
        String text = "The dimensions of a gadget are " + this.dimensions + " mm.";
        return text;
    }

    public abstract void printInfo();

    public abstract void charging(int chargingCurrent);

}
