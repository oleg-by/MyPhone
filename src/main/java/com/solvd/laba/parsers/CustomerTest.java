package com.solvd.laba.parsers;

import com.solvd.laba.model.Order;
import com.solvd.laba.model.User;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "customer")
@XmlType(propOrder = {"id", "firstName", "lastName", "phoneNumber", "dateOfBirth", "user", "orders"})
public class CustomerTest {
    private int id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private Date dateOfBirth;
    private User user;
    private List<Order> orders;

    public CustomerTest() {
    }

    public CustomerTest(int id, String firstName, String lastName, long phoneNumber, Date dateOfBirth, User user, List<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.user = user;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
    @XmlElement
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User getUser() {
        return user;
    }
    @XmlElement
    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @XmlElementWrapper(name = "orders")
    @XmlElement(name = "order", type = Order.class)
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerTest that = (CustomerTest) o;

        if (getId() != that.getId()) return false;
        if (getPhoneNumber() != that.getPhoneNumber()) return false;
        if (!getFirstName().equals(that.getFirstName())) return false;
        if (!getLastName().equals(that.getLastName())) return false;
        if (!getDateOfBirth().equals(that.getDateOfBirth())) return false;
        return getUser() != null ? getUser().equals(that.getUser()) : that.getUser() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + (int) (getPhoneNumber() ^ (getPhoneNumber() >>> 32));
        result = 31 * result + getDateOfBirth().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CustomerTest{" +
                "ID=" + id +
                ", first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", phone number=" + phoneNumber +
                ", date of birth=" + new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirth) +
                ", user=" + user +
                ", orders=" + orders +
                '}';
    }
}
