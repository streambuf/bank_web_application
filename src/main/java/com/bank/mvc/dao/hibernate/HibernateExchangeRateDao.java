package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.ExchangeRateDao;
import com.bank.mvc.models.ExchangeRate;
import com.bank.mvc.models.enums.ListCurrency;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Zalman on 12.05.2015.
 */

@Repository
@Transactional
public class HibernateExchangeRateDao implements ExchangeRateDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public ExchangeRate getByCurrency(ListCurrency currency) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from ExchangeRate e where e.currency=:currency order by e.id desc")
                .setParameter("currency", currency);
        query.setMaxResults(1);
        return (ExchangeRate) query.uniqueResult();



    }

}
