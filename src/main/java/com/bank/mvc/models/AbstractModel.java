package com.bank.mvc.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Zalman on 13.04.2015.
 */
@MappedSuperclass
public class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
