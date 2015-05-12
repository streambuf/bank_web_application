package com.bank.mvc.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zalman on 10.05.2015.
 */

@Entity
@Table(name="bank_account")
public class Account extends AbstractModel  {

    @Column(name="balance")
    private double balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name="currency")
    private ListCurrency currency;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "accountPayee")
    private Set<OperationTransfer> operationsTransfer = new HashSet();

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "accountSender")
    private Set<OperationCurrencyExchange> operationsCurrencyExchangeSender = new HashSet();

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "accountPayee")
    private Set<OperationCurrencyExchange> operationsCurrencyExchangePayee = new HashSet();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ListCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(ListCurrency currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}