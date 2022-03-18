public abstract class Gadget {
    private String type;
    private String brand;
    private String model;
    private String dimensions;
    private String color;
    private int weight;

    public Gadget() {

    }

    public Gadget(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Gadget(String type, String brand, String model, String dimensions, String color, int weight) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.dimensions = dimensions;
        this.color = color;
        this.weight = weight;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getType() {
        return type;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String printSizes() {
         return "The dimensions of a gadget are " + this.dimensions + " mm.";
    }

    public abstract void charging(int chargingCurrent);

}
