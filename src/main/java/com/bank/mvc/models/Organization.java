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

    @Column(name="type_client_identifier")
    private String typeClientIdentifier;

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

    public String getTypeClientIdentifier() {
        return typeClientIdentifier;
    }

    public void setTypeClientIdentifier(String typeClientIdentifier) {
        this.typeClientIdentifier = typeClientIdentifier;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
