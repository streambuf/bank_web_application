package com.bank.mvc.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zalman on 19.05.2015.
 */

@Entity
@Table(name="credit_repayment")
public class CreditRepayment extends AbstractModel {

    @Column(name="quantity_of_money")
    private double quantityOfMoney;

    @Column(name="operation_date")
    private Date operationDate;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private Account account;

    // for serialize html form
    @Transient
    private long creditId;

    // for serialize html form
    @Transient
    private long accountId;

    public double getQuantityOfMoney() {
        return quantityOfMoney;
    }

    public void setQuantityOfMoney(double quantityOfMoney) {
        this.quantityOfMoney = quantityOfMoney;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getCreditId() {
        return creditId;
    }

    public void setCreditId(long creditId) {
        this.creditId = creditId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
