package com.bank.mvc.models;


import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Zalman on 13.04.2015.
 */
@MappedSuperclass
public class AbstractModel {

    @Id
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    private long id;

    public AbstractModel() {}

    public AbstractModel(long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
