package com.bank.mvc.models;

import com.bank.mvc.models.enums.ListPaymentProcedure;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zalman on 21.05.2015.
 */

@Entity
@Table(name="contribution")
public class Contribution extends AbstractModel {

    @Enumerated(EnumType.STRING)
    @Column(name="payment_procedure")
    private ListPaymentProcedure listPaymentProcedure;

    @Column(name="quantity_of_money")
    private double quantityOfMoney;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="period")
    private int period;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "contribution_rate_id")
    private ContributionRate contributionRate;

    // for serialize html form
    @Transient
    private long accountId;

    // for serialize html form
    @Transient
    private long contributionRateId;

    public ListPaymentProcedure getListPaymentProcedure() {
        return listPaymentProcedure;
    }

    public void setListPaymentProcedure(ListPaymentProcedure listPaymentProcedure) {
        this.listPaymentProcedure = listPaymentProcedure;
    }

    public double getQuantityOfMoney() {
        return quantityOfMoney;
    }

    public void setQuantityOfMoney(double quantityOfMoney) {
        this.quantityOfMoney = quantityOfMoney;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ContributionRate getContributionRate() {
        return contributionRate;
    }

    public void setContributionRate(ContributionRate contributionRate) {
        this.contributionRate = contributionRate;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getContributionRateId() {
        return contributionRateId;
    }

    public void setContributionRateId(long contributionRateId) {
        this.contributionRateId = contributionRateId;
    }
}
