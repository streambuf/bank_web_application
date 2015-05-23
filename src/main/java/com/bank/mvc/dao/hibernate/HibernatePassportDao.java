package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.PassportDao;
import com.bank.mvc.models.Passport;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Zalman on 23.05.2015.
 */

@Repository
@Transactional
public class HibernatePassportDao implements PassportDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<Passport> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Passport").list();
    }

    @Override
    public Passport getById(long passportId) {
        return (Passport)sessionFactory.getCurrentSession()
                .get(Passport.class, passportId);
    }

    @Override
    public void save(Passport passport) {
        sessionFactory.getCurrentSession().merge(passport);
    }

    @Override
    public void delete(Passport passport) {
        sessionFactory.getCurrentSession().delete(passport);
    }
}
