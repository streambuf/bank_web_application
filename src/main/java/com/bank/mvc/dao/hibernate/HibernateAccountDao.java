package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.AccountDao;
import com.bank.mvc.models.Account;
import com.bank.mvc.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Zalman on 10.05.2015.
 */

@Repository
@Transactional
public class HibernateAccountDao implements AccountDao {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public Collection<Account> getAll() {
        String hql = "from Account";
        return sessionFactory.getCurrentSession().
                createQuery("from Account").list();
    }

    //@Transactional(readOnly = true)
    @Override
    public Account getById(long userId) {
        return (Account)sessionFactory.getCurrentSession()
                .get(Account.class, userId);
    }

    @Override
    public void save(Account user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public void delete(Account user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
