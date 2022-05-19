package com.solvd.laba.parsers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.laba.model.Purchase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserTest {
    @JsonProperty
    private int id;
    @JsonProperty
    private String username;
    @JsonProperty
    private String email;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birth;
    @JsonProperty
    private List<Purchase> purchases;

    public UserTest() {
    }

    public UserTest(int id, String username, String email, Date createTime, Date birth, List<Purchase> purchases) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createTime = createTime;
        this.birth = birth;
        this.purchases = purchases;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTest userTest = (UserTest) o;

        if (getId() != userTest.getId()) return false;
        if (!getUsername().equals(userTest.getUsername())) return false;
        if (!getEmail().equals(userTest.getEmail())) return false;
        if (!getCreateTime().equals(userTest.getCreateTime())) return false;
        return getBirth().equals(userTest.getBirth());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getCreateTime().hashCode();
        result = 31 * result + getBirth().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime) +
                ", birth=" + new SimpleDateFormat("yyyy-MM-dd").format(birth) +
                ", purchases=" + purchases +
                '}';
    }
}
