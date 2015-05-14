package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.OperationServicesPaymentDao;
import com.bank.mvc.models.OperationServicesPayment;
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
public class HibernateOperationServicesPaymentDao implements OperationServicesPaymentDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<OperationServicesPayment> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from OperationServicesPayment").list();
    }

    @Override
    public OperationServicesPayment getById(long operationServicesPaymentId) {
        return (OperationServicesPayment)sessionFactory.getCurrentSession()
                .get(OperationServicesPayment.class, operationServicesPaymentId);
    }

    @Override
    public void save(OperationServicesPayment operationServicesPayment) {
        sessionFactory.getCurrentSession().merge(operationServicesPayment);
    }

    @Override
    public void delete(OperationServicesPayment operationServicesPayment) {
        sessionFactory.getCurrentSession().delete(operationServicesPayment);
    }
}
