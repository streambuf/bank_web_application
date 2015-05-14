package com.bank.mvc.domain.service;

import com.bank.mvc.models.Service;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */
public interface UtilitiesService {

    public Collection<Service> getAllServices();

    public Service getServiceById(long serviceId);

    public void saveService(Service service);

    public void deleteService(Service service);

}
