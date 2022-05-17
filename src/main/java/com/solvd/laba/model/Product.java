package com.solvd.laba.model;

public class Product {
    private int id;
    private int idCategory;
    private String name;
    private float price;
    private int idDescription;

    public Product() {
    }

    public Product(int id, int idCategory, String name, float price, int idDescription) {
        this.id = id;
        this.idCategory = idCategory;
        this.name = name;
        this.price = price;
        this.idDescription = idDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIdDescription() {
        return idDescription;
    }

    public void setIdDescription(int idDescription) {
        this.idDescription = idDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (getId() != product.getId()) return false;
        if (getIdCategory() != product.getIdCategory()) return false;
        if (Float.compare(product.getPrice(), getPrice()) != 0) return false;
        if (getIdDescription() != product.getIdDescription()) return false;
        return getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getIdCategory();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getPrice() != 0.0f ? Float.floatToIntBits(getPrice()) : 0);
        result = 31 * result + getIdDescription();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", id_category=" + idCategory +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", id_description=" + idDescription +
                '}';
    }
}
