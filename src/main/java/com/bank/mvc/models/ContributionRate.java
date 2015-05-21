package com.bank.mvc.models;

import com.bank.mvc.models.enums.ListCurrency;
import com.bank.mvc.models.enums.ListPeriod;
import com.bank.mvc.models.enums.ListQuantityOfMoney;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zalman on 21.05.2015.
 */

@Entity
@Table(name="contribution_rate")
public class ContributionRate extends AbstractModel {

    @Enumerated(EnumType.STRING)
    @Column(name="period")
    private ListPeriod listPeriod;

    @Enumerated(EnumType.STRING)
    @Column(name="quantity_of_money")
    private ListQuantityOfMoney quantityOfMoney;

    @Enumerated(EnumType.STRING)
    @Column(name="currency")
    private ListCurrency currency;

    @Column(name="rate")
    private double rate;

    @Column(name="start_date")
    private Date startDate;

    public ListPeriod getListPeriod() {
        return listPeriod;
    }

    public void setListPeriod(ListPeriod listPeriod) {
        this.listPeriod = listPeriod;
    }

    public ListQuantityOfMoney getQuantityOfMoney() {
        return quantityOfMoney;
    }

    public void setQuantityOfMoney(ListQuantityOfMoney quantityOfMoney) {
        this.quantityOfMoney = quantityOfMoney;
    }

    public ListCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(ListCurrency currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
