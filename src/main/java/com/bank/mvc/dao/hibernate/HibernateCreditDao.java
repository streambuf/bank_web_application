package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.CreditDao;
import com.bank.mvc.models.Credit;
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
public class HibernateCreditDao implements CreditDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<Credit> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Credit").list();
    }

    @Override
    public Credit getById(long creditId) {
        return (Credit)sessionFactory.getCurrentSession()
                .get(Credit.class, creditId);
    }

    @Override
    public void save(Credit credit) {
        sessionFactory.getCurrentSession().merge(credit);
    }

    @Override
    public void delete(Credit credit) {
        sessionFactory.getCurrentSession().delete(credit);
    }
}
