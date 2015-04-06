package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.ClientDao;
import com.bank.mvc.models.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
@Transactional
public class HibernateClientDao implements ClientDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public Collection<Client> getAll() {
        String hql = "from Client";
        return sessionFactory.getCurrentSession().
                createQuery("from Client").list();
    }

    @Transactional(readOnly = true)
    @Override
    public Client getById(int clientId) {
        return (Client)sessionFactory.getCurrentSession()
                .get(Client.class, clientId);
    }

    @Override
    public void save(Client client) {
        sessionFactory.getCurrentSession().merge(client);
    }

    @Override
    public void delete(Client client) {
        sessionFactory.getCurrentSession().delete(client);
    }


}
