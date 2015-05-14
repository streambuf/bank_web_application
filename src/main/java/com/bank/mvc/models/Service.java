package com.bank.mvc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zalman on 14.05.2015.
 */

@Entity
@Table(name="service")
public class Service extends AbstractModel {

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_services_id")
    private CategoryServices categoryServices;

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "service")
    @OrderBy("name")
    private List<Organization> organizations = new ArrayList<>();

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryServices getCategoryServices() {
        return categoryServices;
    }

    public void setCategoryServices(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }
}
