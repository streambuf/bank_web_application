package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.ContributionDao;
import com.bank.mvc.models.Contribution;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Zalman on 21.05.2015.
 */

@Repository
@Transactional
public class HibernateContributionDao implements ContributionDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<Contribution> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Contribution").list();
    }

    @Override
    public Contribution getById(long contributionId) {
        return (Contribution)sessionFactory.getCurrentSession()
                .get(Contribution.class, contributionId);
    }

    @Override
    public void save(Contribution contribution) {
        sessionFactory.getCurrentSession().merge(contribution);
    }

    @Override
    public void delete(Contribution contribution) {
        sessionFactory.getCurrentSession().delete(contribution);
    }
}
