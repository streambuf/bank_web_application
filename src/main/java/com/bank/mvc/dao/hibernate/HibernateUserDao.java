package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.UserDao;
import com.bank.mvc.models.User;
import com.bank.mvc.models.enums.ListRole;
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
    public Collection<User> getAllUnconfirmed() {
        return sessionFactory.getCurrentSession().
                createQuery("select u.id, u.lname, u.fname, u.patronymic from User u left join u.userRoles r group by u.id, u.lname, u.fname, u.patronymic having count(r)=0").list();
    }

    @Override
    public Collection<User> getAllConfirmed() {
        return sessionFactory.getCurrentSession().
                createQuery("select u from User u join u.userRoles r where r.listRole=:role").setParameter("role", ListRole.ROLE_CLIENT).list();
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
    public void saveOrUpdate(User user) { sessionFactory.getCurrentSession().saveOrUpdate(user);}

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
