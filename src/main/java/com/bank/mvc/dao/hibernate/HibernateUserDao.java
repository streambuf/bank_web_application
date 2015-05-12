package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.UserDao;
import com.bank.mvc.models.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
@Transactional
public class HibernateUserDao implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<User> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from User").list();
    }

    @Override
    public User getById(long userId) {
        return (User)sessionFactory.getCurrentSession()
                .get(User.class, userId);
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }


}
