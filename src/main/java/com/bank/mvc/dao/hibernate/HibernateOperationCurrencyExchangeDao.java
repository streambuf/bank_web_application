package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.OperationCurrencyExchangeDao;
import com.bank.mvc.models.OperationCurrencyExchange;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Zalman on 12.05.2015.
 */

@Repository
@Transactional
public class HibernateOperationCurrencyExchangeDao implements OperationCurrencyExchangeDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<OperationCurrencyExchange> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from OperationCurrencyExchange").list();
    }

    @Override
    public OperationCurrencyExchange getById(long operationCurrencyExchangeId) {
        return (OperationCurrencyExchange)sessionFactory.getCurrentSession()
                .get(OperationCurrencyExchange.class, operationCurrencyExchangeId);
    }

    @Override
    public void save(OperationCurrencyExchange operationCurrencyExchange) {
        sessionFactory.getCurrentSession().merge(operationCurrencyExchange);
    }

    @Override
    public void delete(OperationCurrencyExchange operationCurrencyExchange) {
        sessionFactory.getCurrentSession().delete(operationCurrencyExchange);
    }
}
