package com.solvd.laba.model;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private int idAddressC;
    private int idUser;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, long phoneNumber, int idAddressC, int idUser) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.idAddressC = idAddressC;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdAddressC() {
        return idAddressC;
    }

    public void setIdAddressC(int idAddressC) {
        this.idAddressC = idAddressC;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (getId() != customer.getId()) return false;
        if (getPhoneNumber() != customer.getPhoneNumber()) return false;
        if (getIdAddressC() != customer.getIdAddressC()) return false;
        if (getIdUser() != customer.getIdUser()) return false;
        if (!getFirstName().equals(customer.getFirstName())) return false;
        return getLastName().equals(customer.getLastName());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + (int) (getPhoneNumber() ^ (getPhoneNumber() >>> 32));
        result = 31 * result + getIdAddressC();
        result = 31 * result + getIdUser();
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", idAddressC=" + idAddressC +
                ", idUser=" + idUser +
                '}';
    }
}
