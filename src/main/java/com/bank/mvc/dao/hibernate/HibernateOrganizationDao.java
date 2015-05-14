package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.OrganizationDao;
import com.bank.mvc.models.Organization;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Zalman on 14.05.2015.
 */

@Repository
@Transactional
public class HibernateOrganizationDao implements OrganizationDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<Organization> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Organization").list();
    }

    @Override
    public Organization getById(long organizationId) {
        return (Organization)sessionFactory.getCurrentSession()
                .get(Organization.class, organizationId);
    }

    @Override
    public void save(Organization organization) {
        sessionFactory.getCurrentSession().merge(organization);
    }

    @Override
    public void delete(Organization organization) {
        sessionFactory.getCurrentSession().delete(organization);
    }
}
