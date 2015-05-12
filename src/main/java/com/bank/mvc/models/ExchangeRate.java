package com.bank.mvc.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zalman on 12.05.2015.
 */

@Entity
@Table(name="exchange_rate")
public class ExchangeRate extends AbstractModel {

    @Column(name="nominal")
    private int nominal;

    @Column(name="rate")
    private double rate;

    @Column(name="start_date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name="currency")
    private ListCurrency currency;

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ListCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(ListCurrency currency) {
        this.currency = currency;
    }
}
