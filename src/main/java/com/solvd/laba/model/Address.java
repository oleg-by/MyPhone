package com.solvd.laba.model;

public class Address {
    private int id;
    private String country;
    private String city;
    private String street;
    private int buildingNumber;
    private int corp;
    private int apt;
    private int floor;

    public Address() {
    }

    public Address(int id, String country, String city, String street, int buildingNumber, int apt) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apt = apt;
        this.corp = 0;
        this.floor = 0;
    }

    public Address(int id, String country, String city, String street, int buildingNumber, int corp, int apt) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.corp = corp;
        this.apt = apt;
        this.floor = 0;
    }

    public Address(int id, String country, String city, String street, int buildingNumber) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.corp = 0;
        this.apt = 0;
        this.floor = 0;
    }

    public Address(int id, String country, String city, String street, int buildingNumber, int corp, int apt, int floor) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.corp = corp;
        this.apt = apt;
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getCorp() {
        return corp;
    }

    public void setCorp(int corp) {
        this.corp = corp;
    }

    public int getApt() {
        return apt;
    }

    public void setApt(int apt) {
        this.apt = apt;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (getId() != address.getId()) return false;
        if (getBuildingNumber() != address.getBuildingNumber()) return false;
        if (getCorp() != address.getCorp()) return false;
        if (getApt() != address.getApt()) return false;
        if (!getCountry().equals(address.getCountry())) return false;
        if (!getCity().equals(address.getCity())) return false;
        return getStreet().equals(address.getStreet());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + getBuildingNumber();
        result = 31 * result + getCorp();
        result = 31 * result + getApt();
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", corp=" + corp +
                ", apt=" + apt +
                ", floor=" + floor +
                '}';
    }
}
