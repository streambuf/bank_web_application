package com.bank.mvc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zalman on 19.05.2015.
 */

@Entity
@Table(name="credit")
public class Credit extends AbstractModel {

    @Column(name="quantity_of_money")
    private double quantityOfMoney;

    @Column(name="annual_percentage_rate")
    private double annual_percentage_rate;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="expiration_date")
    private Date expirationDate;

    @Column(name="place_of_work")
    private String placeOfWork;

    @Column(name="salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private Account account;

    // for serialize html form
    @Transient
    private long accountId;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "credit")
    @OrderBy("operation_date")
    private List<CreditRepayment> repayments = new ArrayList<>();

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public double getQuantityOfMoney() {
        return quantityOfMoney;
    }

    public void setQuantityOfMoney(double quantityOfMoney) {
        this.quantityOfMoney = quantityOfMoney;
    }

    public double getAnnual_percentage_rate() {
        return annual_percentage_rate;
    }

    public void setAnnual_percentage_rate(double annual_percentage_rate) {
        this.annual_percentage_rate = annual_percentage_rate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
