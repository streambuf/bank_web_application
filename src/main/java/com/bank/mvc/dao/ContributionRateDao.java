package com.bank.mvc.dao;

import com.bank.mvc.models.ContributionRate;

import java.util.Collection;

/**
 * Created by Zalman on 21.05.2015.
 */
public interface ContributionRateDao {

    public Collection<ContributionRate> getAll();

    public ContributionRate getById(long contributionRateId);

    public void save(ContributionRate contributionRate);

    public void delete(ContributionRate contributionRate);
}
