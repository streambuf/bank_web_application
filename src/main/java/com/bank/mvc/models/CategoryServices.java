package com.bank.mvc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zalman on 14.05.2015.
 */

@Entity
@Table(name="category_services")
public class CategoryServices extends AbstractModel {

    @Column(name="name")
    private String name;

    @Column(name="logotype")
    private String logotype;

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "categoryServices")
    @OrderBy("name")
    private List<Service> services = new ArrayList<>();


    public List<Service> getServices() {
        return services;
    }

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
}
