package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.ServiceDao;
import com.bank.mvc.models.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */

@Repository
@Transactional
public class HibernateServiceDao implements ServiceDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<Service> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Service").list();
    }

    @Override
    public Service getById(long serviceId) {
        return (Service)sessionFactory.getCurrentSession()
                .get(Service.class, serviceId);
    }

    @Override
    public void save(Service service) {
        sessionFactory.getCurrentSession().merge(service);
    }

    @Override
    public void delete(Service service) {
        sessionFactory.getCurrentSession().delete(service);
    }
}
