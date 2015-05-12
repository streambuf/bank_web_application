package com.bank.mvc.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zalman on 12.05.2015.
 */

@Entity
@Table(name="operation_currency_exchange")
public class OperationCurrencyExchange extends  AbstractModel {

    @Column(name="quantity_of_money")
    private double quantityOfMoney;

    @Column(name="operation_date")
    private Date operationDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "sender_bank_account_id")
    private Account accountSender;

    @ManyToOne
    @JoinColumn(name = "payee_bank_account_id")
    private Account accountPayee;

    // for serialize html form
    @Transient
    private long accountSenderId;

    // for serialize html form
    @Transient
    private long accountPayeeId;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccountSender() {
        return accountSender;
    }

    public void setAccountSender(Account accountSender) {
        this.accountSender = accountSender;
    }

    public Account getAccountPayee() {
        return accountPayee;
    }

    public void setAccountPayee(Account accountPayee) {
        this.accountPayee = accountPayee;
    }

    public long getAccountSenderId() {
        return accountSenderId;
    }

    public void setAccountSenderId(long accountSenderId) {
        this.accountSenderId = accountSenderId;
    }

    public long getAccountPayeeId() {
        return accountPayeeId;
    }

    public void setAccountPayeeId(long accountPayeeId) {
        this.accountPayeeId = accountPayeeId;
    }
}
