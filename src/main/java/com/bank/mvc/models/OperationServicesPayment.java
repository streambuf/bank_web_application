package com.bank.mvc.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zalman on 14.05.2015.
 */

@Entity
@Table(name="payment_services")
public class OperationServicesPayment extends AbstractModel {

    @Column(name="client_identifier")
    private String clientIdentifier;

    @Column(name="quantity_of_money")
    private double quantityOfMoney;

    @Column(name="operation_date")
    private Date operationDate;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private Account accountSender;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public String getClientIdentifier() {
        return clientIdentifier;
    }

    // for serialize html form
    @Transient
    private long accountSenderId;

    // for serialize html form
    @Transient
    private long organizationId;

    public long getAccountSenderId() {
        return accountSenderId;
    }

    public void setAccountSenderId(long accountSenderId) {
        this.accountSenderId = accountSenderId;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    public void setClientIdentifier(String clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
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

    public void setAccountSender(Account accountSender) {
        this.accountSender = accountSender;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
