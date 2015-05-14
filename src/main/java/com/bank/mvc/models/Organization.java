package com.bank.mvc.models;

import javax.persistence.*;

/**
 * Created by Zalman on 14.05.2015.
 */

@Entity
@Table(name="organization")
public class Organization extends AbstractModel {

    @Column(name="name")
    private String name;

    @Column(name="logotype")
    private String logotype;

    @Column(name="client_identifier")
    private String clientIdentifier;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogotype() {
        return logotype;
    }

    public void setLogotype(String logotype) {
        this.logotype = logotype;
    }

    public String getClientIdentifier() {
        return clientIdentifier;
    }

    public void setClientIdentifier(String clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
