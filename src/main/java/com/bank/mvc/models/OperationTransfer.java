package com.bank.mvc.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zalman on 11.05.2015.
 */

@Entity
@Table(name="operation_transfer")
public class OperationTransfer extends AbstractModel {

    @Column(name="account_identifier")
    private long accountPayee;

    @Column(name="quantity_of_money")
    private double quantityOfMoney;

    @Column(name="operation_date")
    private Date operationDate;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private Account accountSender;


    // for serialize html form
    @Transient
    private long accountSenderId;

    public long getAccountSenderId() {
        return accountSenderId;
    }

    public void setAccountSenderId(long accountSenderId) {
        this.accountSenderId = accountSenderId;
    }

    public long getAccountPayee() {
        return accountPayee;
    }

    public void setAccountPayee(long accountPayee) {
        this.accountPayee = accountPayee;
    }

    public double getQuantityOfMoney() {
        return quantityOfMoney;
    }

    public void setQuantityOfMoney(double quantityOfMoney) {
        this.quantityOfMoney = quantityOfMoney;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Account getAccountSender() {
        return accountSender;
    }

    public void setAccountSender(Account account) {
        this.accountSender = account;
    }
}
