package com.bank.mvc.models;

import com.bank.mvc.models.enums.ListStatus;

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

    @Column(name="annualPercentageRate")
    private double annualPercentageRate;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="period")
    private int period;

    @Column(name="place_of_work")
    private String placeOfWork;

    @Column(name="salary")
    private double salary;

    @Column(name="monthly_payment")
    private double monthlyPayment;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private Account account;

    // for serialize html form
    @Transient
    private long accountId;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "credit")
    @OrderBy("operation_date")
    private List<CreditRepayment> repayments = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private ListStatus listStatus;

    public ListStatus getListStatus() {
        return listStatus;
    }

    public void setListStatus(ListStatus listStatus) {
        this.listStatus = listStatus;
    }

    public List<CreditRepayment> getRepayments() {
        return repayments;
    }

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

    public double getAnnualPercentageRate() {
        return annualPercentageRate;
    }

    public void setAnnualPercentageRate(double annualPercentageRate) {
        this.annualPercentageRate = annualPercentageRate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
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

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
