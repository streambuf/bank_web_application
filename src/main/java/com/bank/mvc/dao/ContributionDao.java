package com.bank.mvc.dao;

import com.bank.mvc.models.Contribution;

import java.util.Collection;

/**
 * Created by Zalman on 21.05.2015.
 */
public interface ContributionDao {

    public Collection<Contribution> getAll();

    public Contribution getById(long contributionId);

    public void save(Contribution contribution);

    public void delete(Contribution contribution);
}
