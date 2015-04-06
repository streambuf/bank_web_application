package com.bank.mvc.models;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="lname")
    private String lname;

    @Column(name="fname")
    private String fname;

    @Column(name="patronymic")
    private String patronymic;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @Column(name="tin")
    private int tin;

    @Column(name="email")
    private String email;

    @Column(name="citizenship")
    private String citizenship;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    public int getId() {
        return id;
    }

    public String getLname() {
        return lname;
    }

    public String getFname() {
        return fname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDate_of_birth() {
        return dateOfBirth;
    }

    public int getTin() {
        return tin;
    }

    public String getEmail() {
        return email;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.dateOfBirth = date_of_birth;
    }

    public void setTin(int tin) {
        this.tin = tin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
