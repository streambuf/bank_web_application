package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.CreditRepaymentDao;
import com.bank.mvc.models.CreditRepayment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Zalman on 19.05.2015.
 */
@Repository
@Transactional
public class HibernateCreditRepaymentDao implements CreditRepaymentDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<CreditRepayment> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from CreditRepayment").list();
    }

    @Override
    public CreditRepayment getById(long creditRepaymentId) {
        return (CreditRepayment)sessionFactory.getCurrentSession()
                .get(CreditRepayment.class, creditRepaymentId);
    }

    @Override
    public void save(CreditRepayment creditRepayment) {
        sessionFactory.getCurrentSession().merge(creditRepayment);
    }

    @Override
    public void delete(CreditRepayment creditRepayment) {
        sessionFactory.getCurrentSession().delete(creditRepayment);
    }
}
