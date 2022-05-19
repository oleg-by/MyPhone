package com.solvd.laba.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchase {
    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    @JsonProperty
    private float amount;

    public Purchase() {
    }

    public Purchase(int id, String name, Date date, float amount) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (getId() != purchase.getId()) return false;
        if (Float.compare(purchase.getAmount(), getAmount()) != 0) return false;
        if (!getName().equals(purchase.getName())) return false;
        return getDate().equals(purchase.getDate());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + (getAmount() != 0.0f ? Float.floatToIntBits(getAmount()) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) +
                ", amount=$" + amount +
                '}';
    }
}
