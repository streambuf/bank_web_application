package com.bank.mvc.models;

import javax.persistence.*;

/**
 * Created by Zalman on 10.05.2015.
 */

@Entity
@Table(name="bank_account")
public class Account extends AbstractModel  {

    @Column(name="bank_identifier")
    private long bankIdentifier;

    @Column(name="balance")
    private int balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name="currency")
    private ListCurrency currency;

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

    public long getBankIdentifier() {
        return bankIdentifier;
    }

    public void setBankIdentifier(long bankIdentifier) {
        this.bankIdentifier = bankIdentifier;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


}