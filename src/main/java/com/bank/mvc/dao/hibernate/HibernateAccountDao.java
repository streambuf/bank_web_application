package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.AccountDao;
import com.bank.mvc.models.Account;
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
    public Account getById(long accountId) {
        return (Account)sessionFactory.getCurrentSession()
                .get(Account.class, accountId);
    }

    @Override
    public void save(Account account) {
        sessionFactory.getCurrentSession().merge(account);
    }

    @Override
    public void delete(Account account) {
        sessionFactory.getCurrentSession().delete(account);
    }

}
