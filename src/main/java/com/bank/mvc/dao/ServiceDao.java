package com.bank.mvc.dao;

import com.bank.mvc.models.Service;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */
public interface ServiceDao {

    public Collection<Service> getAll();

    public Service getById(long serviceId);

    public void save(Service service);

    public void delete(Service service);
}
