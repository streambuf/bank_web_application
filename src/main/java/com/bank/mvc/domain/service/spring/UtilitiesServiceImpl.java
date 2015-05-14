package com.bank.mvc.domain.service.spring;

import com.bank.mvc.dao.ServiceDao;
import com.bank.mvc.domain.service.UtilitiesService;
import com.bank.mvc.models.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */

@org.springframework.stereotype.Service
public class UtilitiesServiceImpl implements UtilitiesService {
    @Autowired
    private ServiceDao serviceDao;

    @Override
    public Service getServiceById(long serviceId) {
        return serviceDao.getById(serviceId);
    }

    @Override
    public Collection<Service> getAllServices() {
        return serviceDao.getAll();
    }

    @Override
    public void saveService(Service service) {
        serviceDao.save(service);
    }

    @Override
    public void deleteService(Service service) {
        serviceDao.delete(service);
    }
}
