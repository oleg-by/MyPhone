package com.solvd.laba.model;

import com.solvd.laba.enums.AccountType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@XmlRootElement(name = "user")
@XmlType(propOrder = {"id", "username", "email", "password", "createTime", "accountType", "birth", "age"})
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String createTime;
    private AccountType accountType;
    private String birth;
    @XmlElement
    private int age;

    public User() {
    }

    public User(int id, String username, String email, String password, String createTime, AccountType accountType, String birth) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.accountType = accountType;
        this.birth = birth;
        age = calculateAge();
    }

    public User(int id, String username, String email, String password, AccountType accountType, String birth) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.birth = birth;
        createTime = String.valueOf(LocalDateTime.now());
        age = calculateAge();
    }

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    @XmlElement
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }
    @XmlElement
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public AccountType getAccountType() {
        return accountType;
    }
    @XmlElement
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getBirth() {
        return birth;
    }
    @XmlElement
    public void setBirth(String birth) {
        this.birth = birth;
        age = calculateAge();
    }

    public int getAge() {
        return age;
    }

    public int calculateAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(this.birth, formatter);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (!getUsername().equals(user.getUsername())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (getCreateTime() != null ? !getCreateTime().equals(user.getCreateTime()) : user.getCreateTime() != null)
            return false;
        if (getAccountType() != user.getAccountType()) return false;
        return getBirth() != null ? getBirth().equals(user.getBirth()) : user.getBirth() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createTime='" + createTime + '\'' +
                ", accountType=" + accountType +
                ", birth='" + birth + '\'' +
                ", age=" + age +
                '}';
    }
}
