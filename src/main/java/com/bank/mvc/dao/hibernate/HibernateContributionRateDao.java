package com.bank.mvc.dao.hibernate;

import com.bank.mvc.dao.ContributionRateDao;
import com.bank.mvc.models.ContributionRate;
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
public class HibernateContributionRateDao implements ContributionRateDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Collection<ContributionRate> getAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from ContributionRate").list();
    }

    @Override
    public ContributionRate getById(long contributionRateId) {
        return (ContributionRate)sessionFactory.getCurrentSession()
                .get(ContributionRate.class, contributionRateId);
    }

    @Override
    public void save(ContributionRate contributionRate) {
        sessionFactory.getCurrentSession().merge(contributionRate);
    }

    @Override
    public void delete(ContributionRate contributionRate) {
        sessionFactory.getCurrentSession().delete(contributionRate);
    }
}
