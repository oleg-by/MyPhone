package com.solvd.laba.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "order")
@XmlType(propOrder = {"id", "idCustomer", "idProduct", "count", "unitPrice", "orderAmount", "idDelivery", "idPayment"})
public class Order {
    private int id;
    private int idCustomer;
    private int idProduct;
    private int count;
    private float unitPrice;
    @XmlElement
    private float orderAmount;
    private int idDelivery;
    private int idPayment;

    public Order() {
    }

    public Order(int id, int idCustomer, int idProduct, int count, float unitPrice, int idDelivery, int idPayment) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.count = count;
        this.unitPrice = unitPrice;
        this.orderAmount = this.unitPrice * this.count;
        this.idDelivery = idDelivery;
        this.idPayment = idPayment;
    }

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }
    @XmlAttribute
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdProduct() {
        return idProduct;
    }
    @XmlElement
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCount() {
        return count;
    }
    @XmlElement
    public void setCount(int count) {
        this.count = count;
        this.orderAmount = this.count * this.unitPrice;
    }

    public float getUnitPrice() {
        return unitPrice;
    }
    @XmlElement
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
        this.orderAmount = this.count * this.unitPrice;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public int getIdDelivery() {
        return idDelivery;
    }
    @XmlAttribute
    public void setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
    }

    public int getIdPayment() {
        return idPayment;
    }
    @XmlAttribute
    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (getId() != order.getId()) return false;
        if (getIdCustomer() != order.getIdCustomer()) return false;
        if (getIdProduct() != order.getIdProduct()) return false;
        if (getCount() != order.getCount()) return false;
        if (Float.compare(order.getUnitPrice(), getUnitPrice()) != 0) return false;
        if (Float.compare(order.getOrderAmount(), getOrderAmount()) != 0) return false;
        if (getIdDelivery() != order.getIdDelivery()) return false;
        return getIdPayment() == order.getIdPayment();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getIdCustomer();
        result = 31 * result + getIdProduct();
        result = 31 * result + getCount();
        result = 31 * result + (getUnitPrice() != 0.0f ? Float.floatToIntBits(getUnitPrice()) : 0);
        result = 31 * result + (getOrderAmount() != 0.0f ? Float.floatToIntBits(getOrderAmount()) : 0);
        result = 31 * result + getIdDelivery();
        result = 31 * result + getIdPayment();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + id +
                ", customer ID=" + idCustomer +
                ", product ID=" + idProduct +
                ", count=" + count +
                ", unit price=$" + unitPrice +
                ", order amount=$" + orderAmount +
                ", delivery ID=" + idDelivery +
                ", payment ID=" + idPayment +
                '}';
    }
}
